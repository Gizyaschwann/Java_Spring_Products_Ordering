package io.innopolis.products.controllers;

import io.innopolis.products.dto.UserOrderDto;
import io.innopolis.products.models.CustomerOrder;
import io.innopolis.products.models.Product;
import io.innopolis.products.models.User;
import io.innopolis.products.repositories.OrderRepository;
import io.innopolis.products.repositories.ProductRepository;
import io.innopolis.products.repositories.UserRepository;
import io.innopolis.products.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class OrdersController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserOrderDto userOrderDto() {
        return new UserOrderDto();
    }

    @GetMapping("/orders")
    public String ordersList(Model model){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @PostMapping(value="/createorder")
    @ResponseBody
    public String saveOrder(@ModelAttribute("user") @Valid UserOrderDto userDto, BindingResult result, @RequestParam(value="productIds[]") Long[] productIds){

        User customer = userService.findByUsername(userDto.getUsername());

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(userRepository.findById(customer.getId()).orElse(null));
        Set<Product> productSet = new HashSet<Product>();
        for (Long productId:productIds){
            productSet.add(productRepository.findById(productId).orElse(null));
        }
        customerOrder.setProducts(productSet);
        Double total = 0.0;
        for (Long productId:productIds){
            total = total + (productRepository.findById(productId).orElse(null).getProductPrice());
        }
        customerOrder.setTotal(total);
        orderRepository.save(customerOrder);

        return customerOrder.getOrderId().toString();
    }

    @PostMapping("/removeorder")
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        orderRepository.deleteById(Id);
        return Id.toString();
    }
}
