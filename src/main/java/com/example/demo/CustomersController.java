package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController{
    public CustomersController(List<User> users){
        this.users = init();
    }
    private List<User> users;
    private List<User> init(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Janko");
        user1.setLastName("Mrkvicka");
        user1.setEmail("janko.mrkvicka@example.com");

        users.add(user1);

        return users;
    }
    @PostMapping("/api/customer")
    public Integer createCustomer(@RequestBody User user){
        this.users.add(user);
        return this.users.size()-1;
    }
    @GetMapping("/api/customers/{customerId}")
    public User listCustomers(@PathVariable int customerId){
        return this.users.get(customerId);
    }
    @GetMapping("/api/customers")
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
    @GetMapping("/api/customers/{Id}")
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
    @DeleteMapping("/api/customers/{Id}")
    public void deleteCustomer(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    }
}
