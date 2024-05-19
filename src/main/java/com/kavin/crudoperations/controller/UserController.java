package com.kavin.crudoperations.controller;

import com.kavin.crudoperations.dto.ResponseDTO;
import com.kavin.crudoperations.dto.UserDTO;
import com.kavin.crudoperations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }


    @GetMapping("/get")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/find/by/{name}")
    public ResponseDTO findUser(@PathVariable String name){
        return userService.findUser(name);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }
}
