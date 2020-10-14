package com.gaolei.app.service;

import com.gaolei.app.entity.aop.SysLog;

/**
 * 系统日志service
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 13:18
 */

public interface SysLogService {

    boolean saveSysLog(SysLog sysLog);
}
