package com.cydeo.client;

import com.cydeo.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url= "https://dummyapi.io", name= "EMPLOYEE-CLIENT")
public interface EmployeeClient {
// give me a specific Employee
    @GetMapping("/data/v1/user?limit=10")
    Employee getEmployee(@RequestHeader("apo-id") String id);
}
