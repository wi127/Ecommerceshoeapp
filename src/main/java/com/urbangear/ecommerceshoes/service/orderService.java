// com/urbangear/ecommerceshoes/service/ShoeRequestedService.java

package com.urbangear.ecommerceshoes.service;

import com.urbangear.ecommerceshoes.domain.order;
import com.urbangear.ecommerceshoes.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class orderService {

    @Autowired
    private orderRepository orderRepository;

    public List<order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<order> getOrdersById(Long id) {
        return orderRepository.findById(id);
    }

    public order saveOrder(order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
