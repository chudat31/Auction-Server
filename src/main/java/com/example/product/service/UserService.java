package com.example.product.service;

import com.example.product.form.UserForm;
import com.example.product.models.Role;
import com.example.product.models.User;
import com.example.product.repository.results.UserResult;

public interface UserService {
    UserResult getUserByLogin(String username, String password);
    void addRoleToUser(String username, String roleName);
    User saveUser(User user);
    Role saveRole(Role role);
    User getUserByName(String username);
    User addNewUser(UserForm form);
}
