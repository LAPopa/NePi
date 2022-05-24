package com.codecool.nepi.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;   //water, gas etc
    private String name;  // short description
    private String description;
    private String propertyId;  // the property the ticket was generated for
    private String userEmail;  // contact info
    private String userPhonenumber;
    private boolean status;  // false - not solved, true - solved
    private String operatorContractId;  // operator assigned to the ticket

    public Ticket(String type,String name, String description, String propertyId, String userEmail, String userPhonenumber) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.propertyId = propertyId;
        this.userEmail = userEmail;
        this.userPhonenumber = userPhonenumber;
        this.status = false;
        this.operatorContractId = "";
    }


}
