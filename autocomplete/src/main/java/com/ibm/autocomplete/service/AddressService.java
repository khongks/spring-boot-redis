package com.ibm.autocomplete.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ibm.autocomplete.model.Address;
import com.ibm.autocomplete.cache.AddressCache;
 
@Service
public class AddressServices {
	
	@Autowired
	AddresssCache addresssCache;

     
    public List<Address> search(String searchTerm){
    	return addressCache.searchOnCache(searchTerm);
    }
     
    public void evict(String id){
    	addressCache.evict(id);
    }
}