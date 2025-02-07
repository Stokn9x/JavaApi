package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida", 32, "Ida@gmail.dk");
        User user2 = new User(2, "Peter", 22, "Peter@gmail.dk");
        User user3 = new User(3, "Hans", 12, "Hans@gmail.dk");
        User user4 = new User(4, "Frida", 23, "Frida@gmail.dk");
        User user5 = new User(5, "Bo", 20, "Bo@gmail.dk");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id){
        Optional optional = Optional.empty();
        for(User user : userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
