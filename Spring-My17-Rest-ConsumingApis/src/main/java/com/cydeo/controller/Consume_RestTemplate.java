package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //create your APi, I am building my own API
    @GetMapping
    public User[] readAllUsers(){
         // get json body from the third party and converting it to DTO
        /*
        User[].class is passed as the responseType parameter, indicating that the response should be deserialized into an array of User objects.
         */
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);
        return responseEntity.getBody();
        //http://localhost:8080/users ile API consuming my own API
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL = URI+"/{id}";
        return restTemplate.getForObject(URL, Object.class,id);
    }// just care for the one object   http://localhost:8080/users/2
}
