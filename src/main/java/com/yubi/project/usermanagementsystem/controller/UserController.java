package com.yubi.project.usermanagementsystem.controller;

import com.yubi.project.usermanagementsystem.domain.User;
import com.yubi.project.usermanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService UserService;
    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = new ArrayList<>();
        try{
            users = UserService.getAllUser();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getByUserId(@PathVariable("userId") final Integer UserId){
        User user = null;
        try{
            user = UserService.getUserByUserId(UserId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody final User User){
        User UserList = null;
        try{
            UserList = UserService.addUser(User);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<User>(UserList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody final User User){
        String message = "";
        try{
            message = UserService.updateUser(User);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") final Integer userId){
        String message = "";
        try{
            message = UserService.deleteUser(userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
