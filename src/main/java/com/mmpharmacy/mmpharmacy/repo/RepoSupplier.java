package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoSupplier extends JpaRepository<Supplier,Integer> {

    List<Supplier> findAllById(int id);
}


