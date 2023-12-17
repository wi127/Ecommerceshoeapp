// com/urbangear/ecommerceshoes/repository/ShoeRequestedRepository.java

package com.urbangear.ecommerceshoes.repository;

import com.urbangear.ecommerceshoes.domain.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order, Long> {

    // You can add custom queries or methods if needed
}
