package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@Api("demo")
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/demo")
    @ApiModelProperty(value = "demo")
    public int demo(){
        return 1;
    }
}
