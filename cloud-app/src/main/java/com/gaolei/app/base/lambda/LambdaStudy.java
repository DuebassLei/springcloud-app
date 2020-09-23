package com.gaolei.app.base.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 表达式
 * @author DuebassLei
 * @version 1.0
 * @date 2020/9/23 16:43
 */
public class LambdaStudy {
    /**
     * 排序
     * */
    public static void sort(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //旧版本
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //在java8版本中

        //方式一：
        Collections.sort(names,(String a,String b)-> b.compareTo(a));
        //简写
        names.sort((a, b) -> b.compareTo(a));
        //方式二：
        Collections.sort(names, Comparator.reverseOrder());

        names.forEach(System.out::println);

    }

    public static void main(String[] args) {
        sort();
    }
}
