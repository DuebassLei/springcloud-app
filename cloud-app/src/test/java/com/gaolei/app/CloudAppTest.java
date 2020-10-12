package com.gaolei.app;

import com.gaolei.app.util.ice.IceConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DuebassLei
 * @Date 2020/9/21 12:57
 * @Version 1.0
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class CloudAppTest {
 @Test
 public void convert(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<String> aa=IceConvertUtil.toStrArray(list);
        System.out.println(aa);
 }
}
