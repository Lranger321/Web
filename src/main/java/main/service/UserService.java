package main.service;

import main.dto.LoginDTO;
import main.dto.UserDTO;
import main.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO login(LoginDTO dto);

    boolean register(UserDTO dto);
}
