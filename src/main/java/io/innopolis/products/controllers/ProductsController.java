package io.innopolis.products.controllers;

import io.innopolis.products.models.Product;
import io.innopolis.products.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private static Logger logger = LogManager.getLogger(ProductsController.class);

    @Autowired
    ProductRepository productRepository;


    @RequestMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model){
        logger.info("Request for finding an order by id is done");
        model.addAttribute("product", productRepository.findById(id));
        return "product";
    }


    @PostMapping("/saveproduct")
    @ResponseBody

    public String saveProduct(@RequestBody Product product) {

        logger.info("Request for saving a product is done");

        productRepository.save(product);

        logger.info("Product is saved");

        return product.getProductId().toString();
    }

}