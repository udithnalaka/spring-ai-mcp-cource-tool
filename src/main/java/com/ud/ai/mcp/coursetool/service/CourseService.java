package com.ud.ai.mcp.coursetool.service;

import com.ud.ai.mcp.coursetool.pojo.Course;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "get_courses", description = "Get a list of courses")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "get_course", description = "Get a single course by title")
    public Course getCourse(String title) {
        return courses.stream()
                .filter(course -> course.title().contains(title))
                .findFirst()
                .orElse(null);
    }

    @Tool(name = "search_courses", description = "Search courses containing a keyword")
    public List<Course> searchCourses(String keyword) {
        return courses.stream()
                .filter(course -> course.title().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        courses.addAll(List.of(
                new Course("Building Web Applications with Spring Boot", "https://www.youtube.com/watch?v=nKE8pqvhrs8"),
                new Course("Spring Boot Tutorial for Beginners","https://www.youtube.com/watch?v=If1Lw4pLLEo"),
                new Course("Java Design Patterns", "https://www.youtube.com/watch?v=NP7RmrHn1Q0"),
                new Course("No SQL Databases", "https://www.youtube.com/watch?v=FRqrZGB8NBs")
        ));
    }
}
