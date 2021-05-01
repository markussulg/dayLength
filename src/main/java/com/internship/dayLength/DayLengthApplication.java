package com.internship.dayLength;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@SpringBootApplication
@Controller
public class DayLengthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayLengthApplication.class, args);
	}
	@GetMapping
	public String showForm() {

		return "mainView";
	}
	@PostMapping
	public String submitCalculation(@ModelAttribute("lat") String lat, @ModelAttribute("long") String longitude,
									@ModelAttribute("time") String time) {
		System.out.println(lat + longitude + time);
		return "mainView";
	}

}
