package ru.inno.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class SummatorController {

    @RequestMapping(value = "/append", method = RequestMethod.GET)
    public ModelAndView append(@ModelAttribute("sum") Integer sum) {
        ModelAndView modelAndView = new ModelAndView("summator");
        modelAndView.addObject("message", sum);
        return modelAndView;
    }

    @RequestMapping(value = "/append", method = RequestMethod.POST)
    public ModelAndView appendPost(@RequestParam("input") String input,
                                   @ModelAttribute("sum") Integer sum) {
        ModelAndView modelAndView = new ModelAndView("summator");
        Integer param = Integer.valueOf(input);
        sum += param;
        modelAndView.addObject("sum", sum);
        modelAndView.addObject("message", sum);
        return modelAndView;
    }

    @ModelAttribute("sum")
    public Integer publishSum() {
        return 10;
    }

}
