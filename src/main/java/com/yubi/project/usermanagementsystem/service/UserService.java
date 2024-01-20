package com.yubi.project.usermanagementsystem.service;



import com.yubi.project.usermanagementsystem.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getUserByUserId(Integer UserId);
    public User addUser(User User);
    public String updateUser(User User);
    public String deleteUser(Integer userId);

}
