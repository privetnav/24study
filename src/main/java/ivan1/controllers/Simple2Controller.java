package ru.inno.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Simple2Controller {
    @Autowired
    SingletonService singletonService;
    @Autowired
    PrototypeService prototypeService;

    @RequestMapping("/prototype2")
    public ModelAndView getPrototype() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", prototypeService.getValue());
        return modelAndView;
    }

    @RequestMapping("/singleton2")
    public ModelAndView getSingleton() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", singletonService.getValue());
        return modelAndView;
    }

}
