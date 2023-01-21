package com.example.pizza_delivery.service;

import com.example.pizza_delivery.dto.PizzaDTO;
import com.example.pizza_delivery.model.IngredientEntity;
import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.repository.IngredientEntityRepository;
import com.example.pizza_delivery.repository.PizzaEntityRepository;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaEntityRepository pizzaEntityRepository;
    private final IngredientEntityRepository ingredientEntityRepository;



    @Override
    @Transactional
    public PizzaEntity save(PizzaEntity pizzaEntity) {
        return pizzaEntityRepository.save(pizzaEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        pizzaEntityRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PizzaEntity> getALL(){
        return pizzaEntityRepository.findAll();
    }
    @Override
    @Transactional
    public PizzaEntity newPizza(PizzaDTO pizzaDTO){
        List<IngredientEntity> ingredients = new ArrayList<>();

        PizzaEntity pizzaEntity = new PizzaEntity();

        pizzaEntity.setName(pizzaDTO.getName());
        pizzaEntity.setPrice(pizzaDTO.getPrice());
        for(IngredientEntity ingredientEntity : pizzaDTO.getIngredients()){
            ingredients.add(ingredientEntityRepository.findByLabel(ingredientEntity.getLabel()));
        }
        pizzaEntity.setIngredient(ingredients);
        return pizzaEntityRepository.save(pizzaEntity);
    }

    @Override
    @Transactional
    public PizzaEntity updatePizza(PizzaDTO pizzaDTO){
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(pizzaDTO.getName());
        pizzaEntity.setPrice(pizzaDTO.getPrice());
        pizzaEntity.setId(pizzaDTO.getId());
        return pizzaEntityRepository.save(pizzaEntity);
    }

   @Override
   @Transactional(readOnly = true)
   public PizzaEntity getByName(String name) {
        return pizzaEntityRepository.findByName(name);
    }

}
