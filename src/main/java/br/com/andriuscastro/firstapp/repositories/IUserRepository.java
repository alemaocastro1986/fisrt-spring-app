package br.com.andriuscastro.firstapp.repositories;

import br.com.andriuscastro.firstapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
