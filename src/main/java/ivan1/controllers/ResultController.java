package ivan1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {

    @RequestMapping(value="/showResult", method= RequestMethod.GET)
    public String showResult(@ModelAttribute("sum") Integer sum) {
        return "result";
    }



}
