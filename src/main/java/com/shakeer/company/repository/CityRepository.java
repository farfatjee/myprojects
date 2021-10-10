package com.shakeer.company.repository;

import com.shakeer.company.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
