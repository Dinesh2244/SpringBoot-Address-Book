package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressBookController {

    @Autowired
    private AddressService service;

    @PostMapping("/addresses")
    public AddressDTO create(@RequestBody AddressDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/addresses")
    public List<AddressDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/addresses/{id}")
    public AddressDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/addresses/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/addresses/{id}")
    public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO dto) {
        dto.setId(id);
        return service.save(dto);
    }
}
