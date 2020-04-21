package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@Api("demo")
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/text")
    @ApiModelProperty(value = "demo")
    public int addText(String a){
        return 1;
    }

    @PutMapping("/text")
    @ApiModelProperty(value = "demo")
    public int updateText(String a){
        return 1;
    }


    @GetMapping("/text/list")
    @ApiModelProperty(value = "demo")
    public int getTextList(String a){
        return 1;
    }

    @GetMapping("/text/{id}")
    @ApiModelProperty(value = "demo")
    public int getText(String a){
        return 1;
    }
}
