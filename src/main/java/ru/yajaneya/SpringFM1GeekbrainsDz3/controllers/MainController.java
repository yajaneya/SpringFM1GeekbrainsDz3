package ru.yajaneya.SpringFM1GeekbrainsDz3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.yajaneya.SpringFM1GeekbrainsDz3.model.Product;
import ru.yajaneya.SpringFM1GeekbrainsDz3.repositories.ProductRepository;

@Controller
public class MainController {

    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam int a, @RequestParam int b){
        return a + b;
    }

    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String  showProductInfo(@PathVariable Long id){
        return "Product #" + id;
    }

    @GetMapping("/products")
    public String  showProductsPage(Model model){
        model.addAttribute("products", productRepository.getProducts());
        return "products_page";
    }

    @GetMapping("/product")
    public String  showProductPage(Model model){
        Product product = new Product(1, "Milk", 50);
        model.addAttribute("productMilk", product);
        return "product_page";
    }
}
