package com.mclods.taco_cloud_secured.controllers;

import com.mclods.taco_cloud_secured.entities.TacoOrder;
import com.mclods.taco_cloud_secured.entities.User;
import com.mclods.taco_cloud_secured.services.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String showOrderForm(
            @ModelAttribute("tacoOrder") TacoOrder tacoOrder,
            @AuthenticationPrincipal User user
    ) {
        initializeOrderForm(tacoOrder, user);
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid @ModelAttribute("tacoOrder") TacoOrder tacoOrder,
            Errors errors,
            SessionStatus sessionStatus,
            @AuthenticationPrincipal User user
    ) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        tacoOrder.setUser(user);
        orderService.saveOrder(tacoOrder);

        log.info("Order Submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    private void initializeOrderForm(TacoOrder tacoOrder, User user) {
        tacoOrder.setDeliveryName(user.getFullName());
        tacoOrder.setDeliveryStreet(user.getStreet());
        tacoOrder.setDeliveryCity(user.getCity());
        tacoOrder.setDeliveryState(user.getState());
        tacoOrder.setDeliveryZip(user.getZip());
    }
}
