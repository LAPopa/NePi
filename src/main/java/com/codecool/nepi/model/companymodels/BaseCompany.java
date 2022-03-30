package com.codecool.nepi.model.companymodels;

import com.codecool.nepi.model.types.CompanyType;
import com.codecool.nepi.utils.StringListConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BaseCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String companyName;
    private CompanyType companyType;
    private String description;
    @Convert(converter = StringListConverter.class)
    private List<String> allocatedIds;




    public BaseCompany(String companyName, CompanyType companyType, String description) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.description = description;
        this.allocatedIds = new ArrayList<>();
    }

    public void addId(String id) {
        this.allocatedIds.add(id);
    }



    @Override
    public String toString() {
        return "BaseCompany{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyType=" + companyType +
                ", description='" + description + '\'' +
                ", allocatedIds=" + allocatedIds +
                '}';
    }
}
