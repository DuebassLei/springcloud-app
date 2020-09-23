package com.gaolei.app.base.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map 相关操作
 * @author DuebassLei
 * @version 1.0
 * @date 2020/9/23 16:20
 */
public class MapStudy {
    /**
     * 迭代Map
     * @since 1.8
     * */
    public static void forEachMap(){
        Map<Integer, String> namesMap = new HashMap<>(16);
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        //方式一：使用Map的forEach
        namesMap.forEach((k,v)-> System.out.println(k+":"+v));
        //方式二：通过迭代entrySet
        namesMap.entrySet().forEach(entry-> System.out.println(entry.getKey()+":"+entry.getValue()));

    }

    public static void main(String[] args) {
           // forEachMap();
        List<String> names = Arrays.asList("Larry", "Steve", "James");

        //names.forEach(System.out::println);
        //names.forEach(name-> System.out.println(name));
    }

}
