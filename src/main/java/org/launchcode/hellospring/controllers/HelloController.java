package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    //Handles request at path /hello
//    @GetMapping
//   // @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
//
//    @GetMapping("goodbye")
//   // @ResponseBody
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }
//
    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value= "hello", method= {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handles request of form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

 /*   @GetMapping("language-greeting")
    @RequestMapping( method= {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String languageGreeting(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return createMessage(name, language);
    }*/



   /* @ResponseBody
    public String createMessage( String name, String language){
        if(language.equals("French")){
            return "Bonjour, " + name + "!";
        } else if (language.equals("Spanish")){
            return "Hola, " + name + "!";
        } else if (language.equals("German")){
            return "Hallo, " + name + "!";
        }else if (language.equals("Simlish")){
            return "Sul Sul, " + name + "!";
        }else {
            return "Hello, " + name + "!";
        }
    }*/

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
