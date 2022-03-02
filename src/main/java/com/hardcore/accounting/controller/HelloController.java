package com.hardcore.accounting.controller;

import com.hardcore.accounting.model.service.Greeting;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private AtomicLong counter =new AtomicLong();//定义一个计数器,incrementAndGet()先加后取


   // @RequestMapping(path="v1/greeting",method = RequestMethod.GET)
    //但是每次都要输入如上method有点繁琐，做如下改进
    @GetMapping("v1/greeting")
    public Greeting sayHello(@RequestParam("name") String name){
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s",name));

    }
}
