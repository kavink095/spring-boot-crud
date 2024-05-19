package com.kavin.crudoperations.service.impl;

import com.kavin.crudoperations.dto.ResponseDTO;
import com.kavin.crudoperations.dto.UserDTO;
import com.kavin.crudoperations.entity.User;
import com.kavin.crudoperations.repository.UserRepository;
import com.kavin.crudoperations.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseDTO saveUser(UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            User user = new User();

            user.setUserName(userDTO.getUserName());
            user.setMobileNumber(userDTO.getMobileNumber());

            userRepository.save(user);

            responseDTO.setMessage("save user successfully");
            responseDTO.setStatus(String.valueOf(HttpStatus.CREATED));

            return responseDTO;

        } catch (Exception e) {
            log.error("Failed insert new user", e);
            responseDTO.setMessage("Failed insert new user");
            responseDTO.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
            return responseDTO;
        }

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();

        List<User> all = userRepository.findAll();

        all.stream().forEach(data->{
            UserDTO userDTO= new UserDTO();
            userDTO.setUserId(data.getUserId());
            userDTO.setUserName(data.getUserName());
            userDTO.setMobileNumber(data.getMobileNumber());
            userList.add(userDTO);
        });

        return userList;
    }

    @Override
    public ResponseDTO findUser(String name) {

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setData(userRepository.findByUserName(name));
        responseDTO.setMessage("User available");

        return responseDTO;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
