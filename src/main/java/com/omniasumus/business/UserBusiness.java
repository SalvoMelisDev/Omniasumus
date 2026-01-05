package com.omniasumus.business;

import com.omniasumus.models.dto.UserDto;
import com.omniasumus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBusiness {
    @Autowired
    private UserService userService;

    public UserDto login(String username, String password) {
        UserDto user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public UserDto registerUser(UserDto userDto) {
        return userService.registerUser(userDto);
    }
}