package com.unibuc.lab10.mapper;

import com.unibuc.lab10.domain.Address;
import com.unibuc.lab10.dto.AddressDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-17T13:07:18+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setCity( dto.getCity() );
        address.setStreetName( dto.getStreetName() );

        return address;
    }

    @Override
    public AddressDto toDto(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( entity.getId() );
        addressDto.setCity( entity.getCity() );
        addressDto.setStreetName( entity.getStreetName() );

        return addressDto;
    }
}
