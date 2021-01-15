package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.User;
import br.com.andriuscastro.firstapp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
     Optional<User> user =  userRepository.findById(id);
     return user.get();
    }

}