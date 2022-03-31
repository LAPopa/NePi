package com.codecool.nepi.repository;

import com.codecool.nepi.model.propertymodels.PropertyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyObjectRepository extends JpaRepository<PropertyObject, Long> {

    //TODO change state accountCreated false <-> true

    //TODO change state isRented false <-> true

    @Query("SELECT po FROM PropertyObject po WHERE po.enrollmentId = :id")
    PropertyObject getPropertyObjectByEnrollmentId(@Param("id") String enrollmentId);
}
