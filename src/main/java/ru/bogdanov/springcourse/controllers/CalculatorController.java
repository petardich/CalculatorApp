package ru.bogdanov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/first/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) Integer a,
                                 @RequestParam(value = "b", required = false) Integer b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {
        if (a == null || b == null || action == null) {
            model.addAttribute("calculatorMessage",
                    "incorrect data");
            return "calculator";
        }
        double result = 0;
        String operation = "";
        if ("multiplication".equals(action)) {
            result = a * b;
            operation = "*";
        }
        if ("addition".equals(action)) {
            result = a + b;
            operation = "+";
        }
        if ("subtraction".equals(action)) {
            result = a - b;
            operation = "-";
        }
        if ("division".equals(action)) {
            result = ((double) a) / b;
            operation = "/";
        }

        model.addAttribute("calculatorMessage",
                "Result: \n" + a + " " + operation + " " + b + " = " + result);
        return "calculator";
    }
}
