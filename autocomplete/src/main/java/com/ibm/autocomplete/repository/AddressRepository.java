package com.ibm.autocomplete.repository;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {

    @Query(    
        value = "SELECT * FROM Address WHERE street LIKE %:searchTerm%",
        nativeQuery = true
    )
    public List<Person> searchWithNativeQuery(@Param("searchTerm") String searchTerm);
 
    @Query(
        "SELECT p FROM Address p WHERE p.streeet LIKE %:searchTerm%"
    )
    public List<Person> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
}