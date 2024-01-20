package com.yubi.project.usermanagementsystem.service;

import com.yubi.project.usermanagementsystem.domain.User;
import com.yubi.project.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByUserId(Integer UserId) {
        Optional<User> user = userRepository.findById(UserId);
        return user.orElse(null);
    }

    @Override
    public User addUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public String updateUser(User userBody) {
        Integer id = userBody.getId();
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return "User not found";
        }
        user.setFirstName(userBody.getFirstName());
        user.setLastName(userBody.getLastName());
        user.setEmailId(userBody.getEmailId());
        userRepository.save(user);
        return "User updated";
    }

    @Override
    public String deleteUser(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
        } else{
            return "Userid " + userId + " not found";
        }
        return "User " + userOptional.get().getFirstName() + " " + userOptional.get().getLastName() + " is deleted";
    }
}
