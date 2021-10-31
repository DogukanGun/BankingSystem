package com.dag.bankingsystem.controller;

import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.entity.Customer;
import com.dag.bankingsystem.model.request.address.UpdateCreateAddressRequest;
import com.dag.bankingsystem.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public AddressDto createAddress(@RequestBody UpdateCreateAddressRequest updateCreateAddressRequest){
        return addressService.createAddress(updateCreateAddressRequest);
    }

    @PutMapping("{id}")
    public AddressDto updateAddress(@PathVariable int id,@RequestBody UpdateCreateAddressRequest updateCreateAddressRequest){
        return addressService.updateAddress(id,updateCreateAddressRequest);
    }

    @DeleteMapping
    public void deleteAddress(@RequestParam int id){
        addressService.deleteAddress(id);
    }
}
