package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.Category;
import br.com.andriuscastro.firstapp.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category =  categoryRepository.findById(id);
        return category.get();
    }
}
