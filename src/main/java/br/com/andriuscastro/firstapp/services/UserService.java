package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.User;
import br.com.andriuscastro.firstapp.providers.hashProvider.IHashProvider;
import br.com.andriuscastro.firstapp.repositories.IUserRepository;
import br.com.andriuscastro.firstapp.share.exceptions.DataBaseException;
import br.com.andriuscastro.firstapp.share.exceptions.ServiceResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IHashProvider hashProvider;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ServiceResourceNotFoundException(id));
    }

    public User store(User user) {
        user.setPassword(hashProvider.generateHash(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
       try{
           User entity = userRepository.getOne(id);
           entity.setName(user.getName());
           entity.setEmail(user.getEmail());
           entity.setPhone(user.getPhone());

           return userRepository.save(entity);
       }catch (EntityNotFoundException e){
           throw new ServiceResourceNotFoundException(id);
       }

    }

    public void destroy(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {

            throw new ServiceResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataBaseException(ex.getMessage());
        }
    }


}
