package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    private AddressDTO convertToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setName(address.getName());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        return dto;
    }

    private Address convertToEntity(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setName(dto.getName());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        return address;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = convertToEntity(addressDTO);
        Address saved = repository.save(address);
        return convertToDTO(saved);
    }

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addresses = repository.findAll();
        List<AddressDTO> dtos = new ArrayList<>();
        for (Address address : addresses) {
            dtos.add(convertToDTO(address));
        }
        return dtos;
    }

    @Override
    public AddressDTO findById(Long id) {
        Optional<Address> optionalAddress = repository.findById(id);
        if (optionalAddress.isPresent()) {
            return convertToDTO(optionalAddress.get());
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
