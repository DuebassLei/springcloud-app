package com.gaolei.app.controller;

import com.gaolei.app.entity.jxls.Employee;
import com.gaolei.app.entity.jxls.Fish;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Jxls excel 模板导出
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/12 10:41
 */
@Slf4j
@Controller
@Api(tags = "Jxls")
@RequestMapping(value = "/api/jxls")
public class JxlsController {
    /**
     * 模板导出excel
     * @param request
     * @param response
     * @exception IOException
     * */
    @ApiOperation(value = "模板导出excel",notes = "基于模板导出excel文件")
    @PostMapping(value = "export")
    public void jxlsExport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        log.info("Jxls excel simple demo");
        //demo code
        //        List<Employee> employees = generateSampleEmployeeData();
        //        try(
        ////                //InputStream is = Employee.class.getResourceAsStream("object_collection_template.xls")
        //                InputStream is = new ClassPathResource("templates/object_collection_template.xls").getInputStream()
        //        ) {
        //            try (OutputStream os = new FileOutputStream("object_collection_output.xls")) {
        //                Context context = new Context();
        //                context.putVar("employees", employees);
        //                JxlsHelper.getInstance().processTemplate(is, os, context);
        //            }
        //        }

        List<Fish> fishList = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            Fish fish = new Fish();
            fish.setName("小鲤鱼"+i);
            fish.setKind("鲤鱼"+i);
            fish.setPrice("20"+i);
            fishList.add(fish);
        }

        InputStream is = new ClassPathResource("templates/fish.xls").getInputStream();
        // OutputStream os = new FileOutputStream("fishInfos.xls");
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.addHeader("Content-Disposition", "attachment;filename=" + "fish.xls");
            response.setContentType("application/octet-stream");
            Context context = new Context();
            context.putVar("fishList", fishList);
            JxlsHelper.getInstance().processTemplate(is, os, context);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            os.flush();
            os.close();
        }
    }


    /**
     * 带计算函数的excel
     * @param request
     * @param response
     * @exception IOException
     * */
    @ApiOperation(value = "导出计算函数excel",notes = "带计算函数的excel")
    @PostMapping(value = "formulasExport")
    public void jxlsFormulasExport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setName("张三"+i);
            employee.setAge(15+i);
            employee.setBirthDate(new Date());
            employee.setPayment(1500.00);
            employee.setBonus(15.00+i);
            employees.add(employee);
        }
        InputStream is = new ClassPathResource("templates/formulas_template.xls").getInputStream();
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.addHeader("Content-Disposition", "attachment;filename=" + "employeesInfo.xls");
            response.setContentType("application/octet-stream");
            Context context = new Context();
            context.putVar("employees", employees);
            JxlsHelper.getInstance().processTemplate(is, os, context);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            os.flush();
            os.close();
        }



    }
}
