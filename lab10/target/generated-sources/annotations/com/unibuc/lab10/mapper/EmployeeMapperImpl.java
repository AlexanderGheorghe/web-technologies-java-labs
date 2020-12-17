package com.unibuc.lab10.mapper;

import com.unibuc.lab10.domain.Address;
import com.unibuc.lab10.domain.Employee;
import com.unibuc.lab10.dto.AddressDto;
import com.unibuc.lab10.dto.EmployeeDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-17T13:07:18+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( dto.getId() );
        employee.setName( dto.getName() );
        employee.setSalary( dto.getSalary() );
        employee.setAddress( addressDtoToAddress( dto.getAddress() ) );
        employee.setPromoted( dto.getPromoted() );

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( entity.getId() );
        employeeDto.setName( entity.getName() );
        employeeDto.setSalary( entity.getSalary() );
        employeeDto.setAddress( addressToAddressDto( entity.getAddress() ) );
        employeeDto.setPromoted( entity.getPromoted() );

        return employeeDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setCity( addressDto.getCity() );
        address.setStreetName( addressDto.getStreetName() );

        return address;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setCity( address.getCity() );
        addressDto.setStreetName( address.getStreetName() );

        return addressDto;
    }
}
