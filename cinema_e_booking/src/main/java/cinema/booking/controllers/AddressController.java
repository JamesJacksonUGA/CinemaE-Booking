package cinema.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.booking.models.Address;
import cinema.booking.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/address")
	public List<Address> getAllAddresss() {
		return addressService.getAllAddresss();
	}
	
	@GetMapping("/address/{addressId}")
	public Optional<Address> getAddressById(@PathVariable Integer addressId) {
		return addressService.getAddressById(addressId);
	}
	
	@PostMapping("/address")
	public void addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
	}
	
	@PutMapping("/address/{addressId}")
	public void updateAddress(@RequestBody Address address, @PathVariable Integer addressId) {
		addressService.updateAddress(address);
	}
	
	@DeleteMapping("address/{addressId}")
	public void deleteAddressById(@PathVariable Integer addressId) {
		addressService.deleteAddressById(addressId);
	}
	
}
