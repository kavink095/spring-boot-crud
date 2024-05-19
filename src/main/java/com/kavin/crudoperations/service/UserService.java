package com.kavin.crudoperations.service;

import com.kavin.crudoperations.dto.ResponseDTO;
import com.kavin.crudoperations.dto.UserDTO;

import java.util.List;

public interface UserService {

    public ResponseDTO saveUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();

    public ResponseDTO findUser(String name);

    public void deleteUser(int id);

}
