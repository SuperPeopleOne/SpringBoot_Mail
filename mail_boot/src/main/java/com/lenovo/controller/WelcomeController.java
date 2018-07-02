package com.lenovo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@RestController
public class WelcomeController {

    @Value("${welcome.homepage}")
    private String welcome;

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String hello() {
        return welcome;
    }


}
