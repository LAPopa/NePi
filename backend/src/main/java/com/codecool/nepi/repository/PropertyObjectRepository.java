package com.codecool.nepi.repository;

import com.codecool.nepi.entity.PropertyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyObjectRepository extends JpaRepository<PropertyObject, Long> {
    @Query("SELECT po FROM PropertyObject po WHERE po.enrollmentId = :id")
    PropertyObject getPropertyObjectByEnrollmentId(@Param("id") String enrollmentId);
    @Query("select po.accountCreated from PropertyObject po where po.enrollmentId = :id")
    boolean checkIfAccountWasCreated (@Param("id") String enrollmentId);
    @Query("select po.isRented from PropertyObject po where po.enrollmentId = :id")
    boolean checkIsRented(@Param("id") String enrollmentId);
    @Query("select po.streetName from PropertyObject po where po.enrollmentId = :id")
    String checkStreetName(@Param("id") String enrollmentId);
    @Query("select po.streetNumber from PropertyObject po where po.enrollmentId = :id")
    String checkStreetNumber(@Param("id") String enrollmentId);
    @Query("select po.apartmentNumber from PropertyObject po where po.enrollmentId = :id")
    String checkApartmentNumber(@Param("id") String enrollmentId);
}
