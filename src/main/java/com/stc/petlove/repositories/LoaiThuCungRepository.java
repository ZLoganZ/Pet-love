package com.stc.petlove.repositories;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung, String> {
    @Query(value = "{ 'maLoaiThuCung': ?0 }", exists = true)
    boolean findByMaLoaiThuCung(String maLoaiThuCung);
    // CRUD methods
}
