package com.ud.ai.mcp.coursetool;

import com.ud.ai.mcp.coursetool.service.CourseService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CourseToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseToolApplication.class, args);
	}

	@Bean
	public List<ToolCallback> courseTools(CourseService courseService) {
		return List.of(ToolCallbacks.from(courseService));
	}

}
