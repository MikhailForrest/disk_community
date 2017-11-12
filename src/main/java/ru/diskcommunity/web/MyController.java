package ru.diskcommunity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.diskcommunity.service.DisksService;

@Controller
@RequestMapping(value = "/disks")
public class MyController {

    @Autowired
    DisksService disksService;

    @RequestMapping(value="/")
    @ResponseBody
    String home(){
        return "ggg";
    }
}
