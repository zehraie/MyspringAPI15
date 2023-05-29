package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
// we are consuming Api which is the endPoint below
@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT") // baseUrl
public interface UserClient {
//when execute getUsers()it goes the baseUrl+/users endpoint  putting get mapping and bring the data and assign to User List
    @GetMapping("/users")
    List<User> getUsers();
}
