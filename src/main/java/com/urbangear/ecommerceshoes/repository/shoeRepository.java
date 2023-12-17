// com/urbangear/ecommerceshoes/repository/ShoeRepository.java

package com.urbangear.ecommerceshoes.repository;

import com.urbangear.ecommerceshoes.domain.shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shoeRepository extends JpaRepository<shoe, Long> {

    // You can add custom queries or methods if needed
    List<shoe> findByCategory(String category);

}
