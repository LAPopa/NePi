package com.codecool.nepi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketModel {
    String type;
    String name;
    String description;
    String propertyId;
    String userEmail;
    String userPhonenumber;
}
