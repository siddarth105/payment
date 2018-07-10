package com.ecomm.chkt.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class MakePaymentController {

    @RequestMapping(method=RequestMethod.GET, value = "/makePayment")
    public String checkInventory(@RequestParam(value = "amount", required = false) Integer amount) {
        System.out.println("InventoryController :: checkInventory");
        System.out.println("Processing Amount :: " + amount);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}
