package com.example.demo.repositories;
import com.example.demo.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeadRepository extends JpaRepository<Lead, Long> {
}
