package com.dag.bankingsystem.model.mapper;

import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.entity.Address;
import com.dag.bankingsystem.model.request.address.UpdateCreateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressDto convertToAddressDto(Address address);

    void updateAddress(@MappingTarget Address address, UpdateCreateAddressRequest updateCreateAddressRequest);

    Address createAddress(UpdateCreateAddressRequest updateCreateAddressRequest);
}
