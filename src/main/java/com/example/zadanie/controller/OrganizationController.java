package com.example.zadanie.controller;

import com.example.zadanie.model.Organization;
import com.example.zadanie.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для управления организациями.
 * Предоставляет конечные точки для получения списка организаций и информации об отдельной организации.
 */
@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    /**
     * Возвращает список всех организаций. Если передан параметр поиска, возвращает список организаций,
     * соответствующих критериям поиска по полному названию.
     * @param search Поисковый запрос для фильтрации организаций по полному названию (необязательный).
     */
    @GetMapping
    public List<Organization> getOrganizations(@RequestParam(required = false) String search) {
        if (search != null) {
            return organizationService.searchOrganizations(search);
        }
        return organizationService.getAllOrganizations();
    }

    /**
     * Возвращает информацию об организации по её идентификатору.
     * @param id Идентификатор организации.
     * Объект Optional, содержащий информацию об организации, если она найдена.
     */
    @GetMapping("/{id}")
    public Optional<Organization> getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

}
