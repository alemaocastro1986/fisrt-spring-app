package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.Order;
import br.com.andriuscastro.firstapp.entities.User;
import br.com.andriuscastro.firstapp.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> user =  orderRepository.findById(id);
        return user.get();
    }
}
