package com.codecool.nepi.model.companymodels;

import com.codecool.nepi.model.types.CompanyType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter @Setter
public class BaseCompany {

    private String companyName;
    private CompanyType companyType;
    private String description;
    private List<String> allocatedIds;
    private HashMap<String, Boolean> idAvailability;


    public BaseCompany(String companyName,CompanyType companyType, String description) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.description = description;
        this.allocatedIds = new ArrayList<>();
        this.idAvailability = new HashMap<>();
    }

    public void addId(String id){
        this.allocatedIds.add(id);
        this.idAvailability.put(id,true);
    }

    public void assignId(String id){
        this.idAvailability.put(id, false);

    }
}
