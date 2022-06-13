package com.collective.Plants.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.collective.Plants.model.Plants;

public interface PlantsRepository extends JpaRepository<Plants, Long> {
	
		
		@Query(value = "SELECT * FROM PLANTDET ORDER BY GENNTAN", nativeQuery = true)
		List<Plants> findPlantsByAscorder();
		
		@Query(value = "SELECT * FROM PLANTDET ORDER BY GENNTAN DESC", nativeQuery = true)
		List<Plants> findPlantsByDscorder();
		
		@Query(value = "SELECT * FROM PLANTDET WHERE PLANT = :location ORDER BY ?#{#paging}", nativeQuery = true)
		List<Plants> findPlantsBylocation(Pageable paging, @Param("location") String location);
		
		@Query(value = "SELECT * FROM PLANTDET WHERE PLANTNAME = :plantname", nativeQuery = true)
		List<Plants> findPlantDetails(String plantname);
		
		
		
		

}
