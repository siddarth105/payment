package com.ecomm.chkt.payment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class MakePaymentController {

	private final Log log = LogFactory.getLog(getClass());
	
    @RequestMapping(method=RequestMethod.GET, value = "/makePayment")
    public String makePayment(@RequestParam(value = "amount", required = false) Integer amount) {
    		this.log.info("MakePaymentController :: makePayment");
    		this.log.info("Processing Amount :: " + amount);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}
