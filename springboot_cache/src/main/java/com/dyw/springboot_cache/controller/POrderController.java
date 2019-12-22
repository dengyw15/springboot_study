package com.dyw.springboot_cache.controller;

import com.dyw.springboot_cache.bean.POrder;
import com.dyw.springboot_cache.service.POrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class POrderController {

    @Autowired
    POrderService pOrderService;

    @GetMapping("/order/{id}")
    public POrder getOrderById(@PathVariable("id") Integer id) {
        return pOrderService.findByOrderId(id);
    }

    @GetMapping("/order/list")
    public List<POrder> getAllOrders() {
        return pOrderService.findAllOrders();
    }

}
