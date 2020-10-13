package com.gaolei.app.entity.jxls;

import lombok.Data;

import java.util.Date;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/13 12:16
 */
@Data
public class Employee {
    private String name;
    private int age;
    private Double payment;
    private Double bonus;
    private Date birthDate;
    private Employee superior;
}
