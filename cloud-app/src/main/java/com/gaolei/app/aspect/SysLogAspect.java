package com.gaolei.app.aspect;

import com.gaolei.app.anno.SysLogAnnotation;
import com.gaolei.app.entity.aop.SysLog;
import com.gaolei.app.service.SysLogService;
import com.gaolei.app.util.UUIDGenerator;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注解声明切面
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 13:21
 * <pre>
 *     @Aspect注解声明一个切面
 * </pre>
 */

@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;


    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     * 例如：execution(public * com.example.demo.controller.*.*(..))
     */
    @Pointcut("@annotation(com.gaolei.app.anno.SysLogAnnotation)")
    public void logPointCut() {}

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 保存日志
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        SysLog sysLog = new SysLog();
        //获取请求url,ip,httpMethod
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        String url = request.getRequestURL().toString();
        sysLog.setIp(ip);
        sysLog.setHttpMethod(httpMethod);
        sysLog.setUrl(url);
        sysLog.setId(UUIDGenerator.generate());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        sysLog.setExecTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLog.setCreateDate(dateFormat.format(new Date()));
        SysLogAnnotation annotation = method.getAnnotation(SysLogAnnotation.class);
        if(annotation != null){
            //注解上的描述
            sysLog.setRemark(annotation.value());
        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setClassName(className);
        sysLog.setMethodName(methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(new Gson().toJson(o));
            }
            sysLog.setParams(list.toString());
        }catch (Exception e){ }
        sysLogService.saveSysLog(sysLog);
    }

}
