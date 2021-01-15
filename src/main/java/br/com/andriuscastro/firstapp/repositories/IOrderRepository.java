package br.com.andriuscastro.firstapp.repositories;

import br.com.andriuscastro.firstapp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
