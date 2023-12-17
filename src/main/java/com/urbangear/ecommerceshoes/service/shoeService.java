// com/urbangear/ecommerceshoes/service/ShoeService.java

package com.urbangear.ecommerceshoes.service;

import com.urbangear.ecommerceshoes.domain.shoe;
import com.urbangear.ecommerceshoes.repository.shoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class shoeService {

    @Autowired
    private shoeRepository shoeRepository;

    public List<shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

    public Optional<shoe> getShoeById(Long id) {
        return shoeRepository.findById(id);
    }

    public shoe saveShoe(shoe shoe) {
        return shoeRepository.save(shoe);
    }

    public List<shoe> findByCategory(String category) {
        return shoeRepository.findByCategory(category);
    }

    public void deleteShoeById(Long id) { shoeRepository.deleteById(id);}
}
