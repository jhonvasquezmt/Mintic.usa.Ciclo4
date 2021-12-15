package com.usa.retociclo4.repository;

import com.usa.retociclo4.model.CleaningProduct;
import com.usa.retociclo4.repository.crud.CProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JhonV
 */

@Repository
public class CProductRepository {

    @Autowired
    CProductCrudRepository cProductCrudRepository;

    public List<CleaningProduct> getAll(){
        return cProductCrudRepository.findAll();
    }
    public Optional<CleaningProduct> getProduct(int id){
        return cProductCrudRepository.findById(id);
    }
    public CleaningProduct save(CleaningProduct cleaningProduct){ return cProductCrudRepository.save(cleaningProduct);}
    public void delete(CleaningProduct cleaningProduct){ cProductCrudRepository.delete(cleaningProduct);}



}
