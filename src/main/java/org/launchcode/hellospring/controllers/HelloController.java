package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
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
//    //Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
//   //@ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }
//
//    //Handles request of form /hello/LaunchCode
//    @GetMapping("{name}")
//   // @ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    @GetMapping("language_greeting")
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    public String languageGreeting(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage( String n, String l){
        if(l.equals("French")){
            return "Bonjour, " + n + "!";
        } else if (l.equals("Spanish")){
            return "Hola, " + n + "!";
        } else if (l.equals("German")){
            return "Hallo, " + n + "!";
        }else if (l.equals("Simlish")){
            return " Sul Sul, " + n + "!";
        }else {
            return "Hello, " + n + "!";
        }
    }

    @GetMapping("form")
   // @ResponseBody
    public String helloForm(){
        return "<!DOCTYPE html>" +
                "<body>" +
                "<form action= 'language_greeting' method= 'post'>" + // submit a request to /hello
                "<input type= 'text' name= 'name'>" +
                "<label>Language" +
                "<select name= 'language'>" +
                "<option value= 'English'>English</option>" +
                "<option value= 'French'>French</option>" +
                "<option value= 'Spanish'>Spanish</option>" +
                "<option value= 'German'>German</option>" +
                "<option value= 'Simlish'>Simlish</option>" +
                "</select>" +
                "</label>" +
                "<input type= 'submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
