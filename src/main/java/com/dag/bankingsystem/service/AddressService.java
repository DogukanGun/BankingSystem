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

    public AddressDto getAddress(int id){
        return ADDRESS_MAPPER.convertToAddressDto(getAddressById(id));
    }

    public AddressDto updateAddress(int id,UpdateCreateAddressRequest updateCreateAddressRequest){
        Address address = getAddressById(id);
        ADDRESS_MAPPER.updateAddress(address,updateCreateAddressRequest);
        return ADDRESS_MAPPER.convertToAddressDto(addressRepository.save(address));
    }

    private Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(()->new NotFoundException("Address cannot be found"));
    }

    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }
}
