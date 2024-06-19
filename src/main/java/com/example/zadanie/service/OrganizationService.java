package com.example.zadanie.service;

import com.example.zadanie.model.Organization;
import com.example.zadanie.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный класс для управления данными организаций.
 * Обеспечивает доступ к данным через OrganizationRepository.
 */
@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    /**
     * Получает список всех организаций.
     */
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    /**
     * Выполняет поиск организаций по части полного наименования.
     * Игнорирует регистр символов при поиске.
     * @param search Строка для поиска в полном наименовании организации
     */
    public List<Organization> searchOrganizations(String search) {
        return organizationRepository.findByFullNameContainingIgnoreCase(search);
    }

    /**
     * Получает организацию по её идентификатору.
     * @param id Идентификатор организации
     */
    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }
}