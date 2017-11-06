package ivan1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = "sum")
public class SumSessionController {

    @RequestMapping(value = "/append", method = RequestMethod.GET)
    public ModelAndView append(@ModelAttribute("sum") Integer sum){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", sum);
        return modelAndView;
    }

    @RequestMapping(value = "/append", method = RequestMethod.POST)
    public String append(@RequestParam("input") String input,
                         @ModelAttribute("sum") Integer sum,
                         Model model){
        Integer param = Integer.parseInt(input);
        sum = sum + param;

        model.addAttribute("sum", sum);
        return "hello";
    }

    @ModelAttribute
    public void publishSum(Model model){
        if(!model.containsAttribute("sum"))
            model.addAttribute("sum", 10);
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public String move() {
        return "redirect:showResult";
    }

//    @ModelAttribute
//    public String pu

}