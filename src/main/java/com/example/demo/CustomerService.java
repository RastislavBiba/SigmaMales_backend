package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<User> users;
    private CustomerService customerService;
    public Integer createCustomer(@RequestBody User user){
        this.users.add(user);
        return this.users.size()-1;
    }
    public User listCustomers(@PathVariable int customerId){
        return this.users.get(customerId);
    }
    public List<User> getList(@RequestParam(required = false) String firstName){
        List<User> filteredUsers = new ArrayList<>();
        for (User user : users){
            if (user.getFirstName().equals(firstName)){
                filteredUsers.add(user);
            }
        }
        User user = new User();
        return this.users;
    }
    public List<User> getUserId(@RequestParam(required = false) Integer customerId){
        List<User> filteredUsers = new ArrayList<>();
        for (User user : users){
            if (user.getId() == customerId){
                filteredUsers.add(user);
            }
        }
        User user = new User();
        return this.users;
    }
    public void deleteCustomer(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    }
}
