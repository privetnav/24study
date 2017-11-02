package ru.inno.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

    @Autowired
    PrototypeService prototypeService;
    @Autowired
    SessionService sessionService;
    @Autowired
    SingletonService singletonService;
    @Autowired
    RequestService requestService;

    @RequestMapping("/singleton")
    public ModelAndView getSingleton() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", singletonService.getValue());
        return modelAndView;
    }

    @RequestMapping("/prototype")
    public ModelAndView getPrototype() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", prototypeService.getValue());
        return modelAndView;
    }

    @RequestMapping("/session")
    public ModelAndView getSession() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", sessionService.getValue());
        return modelAndView;
    }

    @RequestMapping("/request")
    public ModelAndView getRequset() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", requestService.getValue());
        return modelAndView;
    }

}
