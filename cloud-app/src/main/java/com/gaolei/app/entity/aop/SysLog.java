package com.gaolei.app.entity.aop;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;


/**
 * 日志实体类
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 13:17
 */
@Table(name = "sys_log")
@Entity
@Data
@ApiModel(value = "日志实体类")
public class SysLog {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    /**
     * 类名
     * */
    @Column(nullable = false)
    private String className;

    /**
     * 方法名
     * */
    @Column(nullable = false)
    private String methodName;

    /**
     * 参数
     * */
    @Column(nullable = false)
    private String params;

    /**
     * 执行时间
     * */
    @Column(nullable = false)
    private Long execTime;

    /**
     * 切面标记
     * */
    private String remark;

    /**
     * 创建时间
     * */
    @Column(nullable = false)
    private String createDate;

    /**
     * 请求URL
     * */
    @Column(nullable = false)
    private String url;

    /**
     * 请求IP
     * */
    @Column(nullable = false)
    private String ip;

    /**
     * http method
     * */
    @Column(nullable = false)
    private String httpMethod;

}
