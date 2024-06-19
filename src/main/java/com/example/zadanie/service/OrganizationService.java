package com.example.zadanie.service;

import com.example.zadanie.model.Organization;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный интерфейс для управления данными организаций.
 * Предоставляет методы для получения списка всех организаций, выполнения поиска организаций по фильтру и получения
 * организации по её уникальному идентификатору.
 */
public interface OrganizationService {

    /**
     * Получает список всех организаций.
     */
    List<Organization> getAllOrganizations();

    /**
     * Выполняет поиск организаций по фильтру.
     * @param search Строка для поиска по фильтру
     */
    List<Organization> searchOrganizations(String search);

    /**
     * Получает организацию по её идентификатору.
     * @param id Идентификатор организации
     */
    Optional<Organization> getOrganizationById(int id);

}