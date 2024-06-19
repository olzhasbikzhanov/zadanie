package com.example.zadanie.repository;

import com.example.zadanie.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для доступа к данным организаций.
 * Использует Spring Data JPA для выполнения основных операций.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByFullNameContainingIgnoreCase(String fullName);

}
