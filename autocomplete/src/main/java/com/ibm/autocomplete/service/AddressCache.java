package com.ibm.autocomplete.model;

@Component
@CacheConfig(cacheNames = {"addresses"})
public class AddressCache {
	
	@Autowired
	AddresssRepository addressRepository;
	
	@Cacheable(key="#id")
    public List<Address> searchOnCache(String searchTerm){
    	System.out.println("############# Backend processing...");
        return addressRepository.searchWithNativeQuery(searchTerm);
    }
}