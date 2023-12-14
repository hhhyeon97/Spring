package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data","hello!!");
        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("...");
        return "hello-template";

    }

    @ResponseBody
    @GetMapping("hello-string")
    public String helloString(@RequestParam("name") String name){

        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

// 테스트 !
    @GetMapping("/api/data")
    @ResponseBody
    public Map<String, String> getSomeData() {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        data.put("key2", "안녕");
        data.put("key3", "바이");
        data.put("key4", "hello");
        return data;
    }

}
