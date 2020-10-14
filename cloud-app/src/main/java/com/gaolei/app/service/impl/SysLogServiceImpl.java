package com.gaolei.app.service.impl;

import com.gaolei.app.entity.aop.SysLog;
import com.gaolei.app.repository.SysLogRepository;
import com.gaolei.app.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志serviceImpl
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 17:00
 */
@Slf4j
@Service
public class SysLogServiceImpl  implements SysLogService {
    @Autowired
    private SysLogRepository sysLogRepository;

    @Override
    public boolean saveSysLog(SysLog sysLog){
        sysLogRepository.save(sysLog);
//        log.info(sysLog.getParams());
        log.info("成功");
        return true;
    }

}
