package br.com.andriuscastro.firstapp.repositories;

import br.com.andriuscastro.firstapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
