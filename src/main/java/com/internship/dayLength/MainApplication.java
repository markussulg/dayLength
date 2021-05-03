package com.internship.dayLength;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.internship.dayLength.api.DayLength;
import com.internship.dayLength.api.ResponseBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@Controller
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("result", new DayLength("N/A", "N/A", "N/A"));
        return "mainView";
    }

    @PostMapping
    @org.springframework.web.bind.annotation.ResponseBody
    public String submitCalculation(@ModelAttribute("lat") String lat, @ModelAttribute("long") String longitude,
                                    @ModelAttribute("time") String time) throws IOException, InterruptedException {
        DayLength response;
        try {
            final ResponseBody dayLength = getDayLength(lat, longitude, time);
            response = dayLength.getResult();
        } catch (MismatchedInputException e) {
            System.out.println("Exception: " + e);
            response = new DayLength("N/A", "N/A", "N/A");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(response);
    }

    //API homepage: https://sunrise-sunset.org/api
    public static ResponseBody getDayLength(String lat, String longitude, String time) throws IOException, InterruptedException {
        //System.out.println(time);
        String newRequest = String.format("https://api.sunrise-sunset.org/json?lat=%s&lng=%s&date=%s", lat, longitude, time);
        System.out.println(newRequest);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(newRequest))
                .GET()
                .build();
        final HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        return mapper.readValue(response.body(), ResponseBody.class);
    }

}
