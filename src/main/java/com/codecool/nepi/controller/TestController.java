package com.codecool.nepi.controller;


import com.codecool.nepi.model.TestModel;
import com.codecool.nepi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TestController {


    TestService testService = TestService.getInstance();

    @GetMapping("/test-get-all")
    public List<TestModel> getAllElements() {
        return testService.getAllStoredElements();
    }

    @PostMapping("/test-post-new")
    public  void addNewElement (@RequestBody TestModel newElement) {
        testService.addNewElement(newElement);
    }
}
