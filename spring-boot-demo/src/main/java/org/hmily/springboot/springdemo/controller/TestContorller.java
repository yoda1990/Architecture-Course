package org.hmily.springboot.springdemo.controller;


import org.hmily.springboot.starter.configuration.FormatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {

    @Autowired
    private FormatTemplate formatTemplate;

    @RequestMapping("/test")
    public String test(){
        User user =new User();
        user.setName("Hmily");
        user.setAge(18);
        return formatTemplate.doFormat(user);
    }


    public static class User{

        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
