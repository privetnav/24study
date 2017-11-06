package ivan1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @RequestMapping(value = "/task")
    public ModelAndView getTest() {
        ModelAndView modelAndView = new ModelAndView("task");
        modelAndView.addObject("task", "Test info task");
        return modelAndView;
    }

}
