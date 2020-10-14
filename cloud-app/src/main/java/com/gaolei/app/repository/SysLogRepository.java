package com.gaolei.app.repository;

import com.gaolei.app.entity.aop.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 16:56
 */

public interface SysLogRepository extends JpaRepository<SysLog,String> {
}
