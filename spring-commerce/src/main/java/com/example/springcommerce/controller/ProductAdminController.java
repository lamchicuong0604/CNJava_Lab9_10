package com.example.springcommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductAdminController {

    @RequestMapping(value = {"/product"})
    public String homePage(){
        return "productadmin";
    }

    @RequestMapping(value = {"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"/regis"})
    public String regis(){
        return "regis";
    }
}
