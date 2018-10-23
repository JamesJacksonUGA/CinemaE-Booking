package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Address;
import cinema.booking.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	public List<Address> getAllAddresss() {
		List<Address> addresss = new ArrayList<>();
		addressRepository.findAll().forEach(addresss::add);
		return addresss;
	}

	public Optional<Address> getAddressById(Integer addressId) {
		return addressRepository.findById(addressId);
	}
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public void updateAddress(Address address) {
		addressRepository.save(address);
	}
	
	public void deleteAddressById(Integer addressId) {
		addressRepository.deleteById(addressId);
	}
	
}
