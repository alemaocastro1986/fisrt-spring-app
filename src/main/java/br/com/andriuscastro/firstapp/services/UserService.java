package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.User;
import br.com.andriuscastro.firstapp.repositories.IUserRepository;
import br.com.andriuscastro.firstapp.share.exceptions.ServiceResourceNotFoundException;
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
     return user.orElseThrow(() -> new ServiceResourceNotFoundException(id));
    }

    public User store(User user){
        return userRepository.save(user);
    }

    public User update(Long id, User user){
        User entity = userRepository.getOne(id);
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());

        return userRepository.save(entity);

    }

    public void destroy(Long id){
        userRepository.deleteById(id);
    }


}
