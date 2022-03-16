package com.codecool.nepi.service;


import com.codecool.nepi.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private List<TestModel> testModels;
    private static TestService instance = null;

    public TestService(){
        this.testModels = new ArrayList<>();
        populateList();
    }

    public static TestService getInstance(){
        if(instance == null) {
            instance = new TestService();

        }
        return instance;
    }

    public List<TestModel> getAllStoredElements() {
        return testModels;
    }

    public void addNewElement(TestModel testModel) {
        testModels.add(testModel);
    }

    private void populateList(){
        this.testModels.add(new TestModel(1,"First entry", 13));
        this.testModels.add(new TestModel(2,"Second entry", 56));
        this.testModels.add(new TestModel(3,"A cat", 9));
        this.testModels.add(new TestModel(4,"Meow", 999));
    }
}
