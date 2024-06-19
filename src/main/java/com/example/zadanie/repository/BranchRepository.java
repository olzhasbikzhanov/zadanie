package com.example.zadanie.repository;

import com.example.zadanie.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для доступа к данным филиалов.
 * Использует Spring Data JPA для выполнения основных операций.
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
