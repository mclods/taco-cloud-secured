package com.mclods.taco_cloud_secured.controllers;

import com.mclods.taco_cloud_secured.entities.TacoOrder;
import com.mclods.taco_cloud_secured.services.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String showOrderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder,
            Errors errors,
            SessionStatus sessionStatus
    ) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        orderService.saveOrder(tacoOrder);

        log.info("Order Submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
