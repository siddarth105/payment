package com.ecomm.chkt.payment.controller;

import com.ecomm.chkt.payment.service.AddPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class MakePaymentController {

    @Autowired
    private AddPaymentService addPaymentService;

    @RequestMapping(method=RequestMethod.GET, value = "/makePayment")
    public String checkInventory(@RequestParam(value = "amount", required = false) float amount,
                                 @RequestParam(value = "orderId", required = false) Integer orderId) {
        System.out.println("InventoryController :: checkInventory");
        System.out.println("Processing Amount :: " + amount);
        try {
            Thread.sleep(20000);
            addPaymentService.addPayment(orderId, amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}
