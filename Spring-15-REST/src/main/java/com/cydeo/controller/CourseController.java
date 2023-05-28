package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController  //@Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@ResponseBody  //bunun yerine RestController kullaniyoruz
    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")   //http://localhost:8080/courses/category/Spring
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    //create course
    //@RequestBody capturing information from raw
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }


    @PutMapping("{id}")  //Which Object I need to update, how you will capture the object
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course) {
    courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    void deleteCourses(){
        courseService.deleteCourses();
    }
}