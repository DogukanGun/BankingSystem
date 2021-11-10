package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.entity.Address;
import com.dag.bankingsystem.repository.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @InjectMocks
    public AddressService sut;

    @Mock
    private AddressRepository addressRepository;

    @Captor
    private ArgumentCaptor<Address> addressArgumentCaptor;

    private AddressDto addressDto;

    @BeforeEach
    void setup(){
        addressDto = AddressDto.builder()
                .id(0)
                .buildingNumber("1")
                .city("izmir")
                .build();

    }

    @Test
    void it_should_return_expected_address(){
        //Given
        when(addressRepository.findById(eq(0))).thenReturn(
                Optional.of(Address.builder()
                        .id(0)
                        .buildingNumber("1")
                        .city("izmir")
                        .build())
        );

        //When
        AddressDto addressDtoFromRepo = sut.getAddress(eq(0));

        //Then
        Assertions.assertEquals(addressDto.getId(),addressDtoFromRepo.getId());
        Assertions.assertEquals(addressDto.getCity(),addressDtoFromRepo.getCity());
        Assertions.assertEquals(addressDto.getBuildingNumber(),addressDtoFromRepo.getBuildingNumber());


    }
}
