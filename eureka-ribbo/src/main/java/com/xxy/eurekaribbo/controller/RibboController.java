package com.xxy.eurekaribbo.controller;

import com.xxy.eurekaribbo.service.RibboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RibboController {

    @Autowired
    RibboService ribboService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return ribboService.hiService(name);
    }
}

