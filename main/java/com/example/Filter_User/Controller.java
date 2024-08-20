package com.example.Filter_User;

import com.example.Filter_User.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    private List<User> users = new ArrayList<>();

    public Controller(){
        users.add(new User(1,"Alice",25,"NewYork"));
        users.add(new User(2, "Bob", 30, "LosAngeles"));
        users.add(new User(3, "Charlie", 25, "NewYork"));
        users.add(new User(4, "David", 35, "Chicago"));
    }

    @GetMapping("/users/filter")
    public List<User> filterUsers(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String city){
        return users.stream().filter(user -> (age == null || user.getAge() == age) &&
                        (city == null || user.getCity().equalsIgnoreCase(city)))
                .collect(Collectors.toList());
    }
}
