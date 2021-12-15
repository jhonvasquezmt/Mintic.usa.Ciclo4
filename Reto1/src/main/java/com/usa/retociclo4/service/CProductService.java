package com.usa.retociclo4.service;

import com.usa.retociclo4.model.CleaningProduct;
import com.usa.retociclo4.repository.CProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JhonV
 */
@Service
public class CProductService {

    @Autowired
    CProductRepository cProductRepository;

    public List<CleaningProduct> getAll(){
        return cProductRepository.getAll();
    }
    public Optional<CleaningProduct> getProduct(int id){
        return cProductRepository.getProduct(id);
    }

    public CleaningProduct save(CleaningProduct product){
        if (product.getId()==null){
                            return cProductRepository.save(product);
            } else {
            Optional<CleaningProduct> productDb=cProductRepository.getProduct(product.getId());
            if (productDb.isEmpty()) {
                return cProductRepository.save(product);

            } else {
                return product;
            }

        }
    }
    public CleaningProduct update(CleaningProduct newProduct){

        if(newProduct.getId()!=null){
            Optional<CleaningProduct> dbProduct=cProductRepository.getProduct(newProduct.getId());
            if(!dbProduct.isEmpty()){
                if(newProduct.getBrand()!=null){
                    dbProduct.get().setBrand(newProduct.getBrand());
                }
                if(newProduct.getCategory()!=null){
                    dbProduct.get().setCategory(newProduct.getCategory());
                }
                if(newProduct.getPresentation()!=null){
                    dbProduct.get().setPresentation(newProduct.getPresentation());
                }
                if(newProduct.getDescription()!=null){
                    dbProduct.get().setDescription(newProduct.getDescription());
                }
                if(newProduct.getPrice()!=null){
                    dbProduct.get().setPrice(newProduct.getPrice());
                }
                if(newProduct.getAvailability()!=null){
                    dbProduct.get().setAvailability(newProduct.getAvailability());
                }
                if(newProduct.getQuantity()!=null){
                    dbProduct.get().setQuantity(newProduct.getQuantity());
                }
                if(newProduct.getPhotography()!=null){
                    dbProduct.get().setPhotography(newProduct.getPhotography());
                }
                return cProductRepository.save(dbProduct.get());

            }
        }
        return newProduct;
    }

    public boolean deleteProduct(int id){
        Optional<CleaningProduct> product=getProduct(id);
        if(!product.isEmpty()){
            cProductRepository.delete(product.get());
            return true;
        }
        return false;

    }
}
