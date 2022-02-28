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
    private CustomerService customerService;
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
        return customerService.createCustomer(user);
    }
    @GetMapping("/api/customers/{customerId}")
    public User listCustomers(@PathVariable int customerId){
        return customerService.listCustomers(customerId);
    }
    @GetMapping("/api/customers")
    public List<User> getList(@RequestParam(required = false) String firstName){

        return customerService.getList(firstName);
    }
    @GetMapping("/api/customers/{Id}")
    public List<User> getUserId(@RequestParam(required = false) Integer customerId){

        return customerService.getUserId(customerId);
    }
    @DeleteMapping("/api/customers/{Id}")
    public void deleteCustomer(@PathVariable Integer userId){
        customerService.deleteCustomer(userId);
    }
}
