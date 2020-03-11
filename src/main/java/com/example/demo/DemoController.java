package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.image.ImageWatched;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@Api("demo")
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DezhouPokerServvice dezhouPokerServvice;

    @PostMapping("/demo")
    @ApiModelProperty(value = "demo")
    public Pokers demo(@RequestBody List<Poker> list){
        list = list.stream().sorted(Comparator.comparing(Poker::getValue)).collect(Collectors.toList());
        Pokers pokers = new Pokers(list);
        return pokers;
    }
}
