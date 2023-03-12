package com.example.advengtest.repositories;

import com.example.advengtest.models.Subproject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubprojectRepository extends JpaRepository<Subproject, Integer> {
    Subproject findById(int id);
    List<Subproject> findAllByProjectId(int id);
}
