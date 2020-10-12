package com.gaolei.app.controller;

import com.gaolei.app.entity.Shop;
import com.gaolei.app.repository.EsRepository;
import com.gaolei.app.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/9/29 18:34
 */
@Controller
@RequestMapping("/es")
public class EsController {

    @Autowired
    private  EsRepository es;

    @RequestMapping(value = "addEs",method = RequestMethod.GET)
    public void addShopEs() {
        //模拟数据
        List<Shop> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Shop shop = new Shop();
            shop.setId(UUIDGenerator.generate());
            shop.setReducedprice(14L+i);
            shop.setShopname("玻璃"+i);
            es.save(shop);
        }
    }
}
