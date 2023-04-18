package com.stc.petlove.repositories;

import com.stc.petlove.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends MongoRepository<DichVu, String> {
    // CRUD methods
}
