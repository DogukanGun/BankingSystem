package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.entity.Address;
import com.dag.bankingsystem.model.request.address.UpdateCreateAddressRequest;
import com.dag.bankingsystem.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.AddressMapper.ADDRESS_MAPPER;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public AddressDto createAddress(UpdateCreateAddressRequest updateCreateAddressRequest){
        Address address = ADDRESS_MAPPER.createAddress(updateCreateAddressRequest);
        return ADDRESS_MAPPER.convertToAddressDto(addressRepository.save(address));
    }

    public AddressDto updateAddress(int id,UpdateCreateAddressRequest updateCreateAddressRequest){
        Address address = addressRepository.findById(id).orElseThrow(()->new NotFoundException("Address is not found"));
        ADDRESS_MAPPER.updateAddress(address,updateCreateAddressRequest);
        return ADDRESS_MAPPER.convertToAddressDto(addressRepository.save(address));
    }

    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }
}
