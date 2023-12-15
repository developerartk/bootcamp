package com.artur.assignment.service.patternServices;


import com.artur.assignment.Strategy.PaymentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentHandler paymentHandler;
    private int sum;

    @Autowired
    public OrderService(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    public int setSum(int sum){
        this.sum = sum;
        return sum;
    }

    public int getSum(){
        return sum;
    }

    public boolean checkout(){
        paymentHandler.setSum(sum);
        return paymentHandler.finishPayment();
    }

    public String getErrorMessage(){
        return paymentHandler.getErrorMessage();
    }



}
