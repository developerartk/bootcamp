package com.artur.assignment.controllers.patternControllers;


import com.artur.assignment.service.patternServices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class PaymentController {
    private OrderService orderService;

    @Autowired
    public PaymentController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/cart")
    public String addOrder(@ModelAttribute("order") OrderService order){

        return "/order/cart";
    }

    @GetMapping("/checkout")
    public String checkout(@ModelAttribute("order") OrderService order, Model model){
        orderService.setSum(order.getSum());
        if(orderService.checkout() == true){
           return "/order/paymentApprove";
        }else{
            model.addAttribute("errorMessage", orderService.getErrorMessage());
            return "/order/paymentError";
        }
    }
}
