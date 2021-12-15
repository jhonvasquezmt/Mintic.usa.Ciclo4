package com.usa.retociclo4.repository.crud;

import com.usa.retociclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CProductCrudRepository extends MongoRepository<CleaningProduct, Integer> {
}
