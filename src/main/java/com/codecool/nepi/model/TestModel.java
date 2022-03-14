package com.codecool.nepi.model;


import lombok.*;

@AllArgsConstructor
@Builder
@Getter @Setter
@ToString
public class TestModel {

    private int id;
    private String name;
    private int magicNumber;
}
