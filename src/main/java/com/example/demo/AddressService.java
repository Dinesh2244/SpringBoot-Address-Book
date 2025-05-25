package com.example.demo;


import java.util.List;

public interface AddressService {
    AddressDTO save(AddressDTO addressDTO);
    List<AddressDTO> findAll();
    AddressDTO findById(Long id);
    void deleteById(Long id);
}
