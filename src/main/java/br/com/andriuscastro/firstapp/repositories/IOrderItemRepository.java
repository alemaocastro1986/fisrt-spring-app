package br.com.andriuscastro.firstapp.repositories;

import br.com.andriuscastro.firstapp.entities.OrderItem;
import br.com.andriuscastro.firstapp.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
