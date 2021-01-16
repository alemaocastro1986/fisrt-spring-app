package br.com.andriuscastro.firstapp.repositories;

import br.com.andriuscastro.firstapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
