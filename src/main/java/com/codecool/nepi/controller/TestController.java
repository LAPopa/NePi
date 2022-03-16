package com.codecool.nepi.controller;


import com.codecool.nepi.model.TestModel;
import com.codecool.nepi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TestController {


    TestService testService = TestService.getInstance();

    @GetMapping("/testing-route")
    public List<TestModel> getAllElements() {
        return testService.getAllStoredElements();
    }

    @PostMapping("/testing-route")
    public ResponseEntity<Void> addNewElement (@RequestBody TestModel newElement) {

        testService.addNewElement(newElement);
//        return "redirect:/testing-route";
        return ResponseEntity.status(HttpStatus.OK).location(URI.create("http://localhost:3000/")).build();
    }
}
