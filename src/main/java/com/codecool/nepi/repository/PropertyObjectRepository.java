package com.codecool.nepi.repository;

import com.codecool.nepi.model.propertymodels.PropertyObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyObjectRepository extends JpaRepository<PropertyObject, Long> {

    //TODO change state accountCreated false <-> true

    //TODO change state isRented false <-> true
}
