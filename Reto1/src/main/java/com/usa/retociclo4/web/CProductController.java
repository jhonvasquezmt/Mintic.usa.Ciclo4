package com.usa.retociclo4.web;

import com.usa.retociclo4.model.CleaningProduct;
import com.usa.retociclo4.service.CProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JhonV
 */
@RestController
@RequestMapping("/api/cleaningprod")
public class CProductController {

    @Autowired
    CProductService cProductService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll(){
        return cProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getUser(@PathVariable("id") int id){
        return cProductService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct save(@RequestBody CleaningProduct product){
        return cProductService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cProductService.deleteProduct(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct product){
        return cProductService.update(product);
    }
}
