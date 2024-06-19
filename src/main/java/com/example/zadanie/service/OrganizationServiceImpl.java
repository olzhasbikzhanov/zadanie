package com.example.zadanie.service;

import com.example.zadanie.model.Branch;
import com.example.zadanie.model.Organization;
import com.example.zadanie.repository.BranchRepository;
import com.example.zadanie.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Сервисный класс для управления данными организаций.
 * Обеспечивает доступ к данным через OrganizationRepository.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final BranchRepository branchRepository;

    /**
     * Метод, вызываемый при инициализации приложения, который создает и сохраняет в базу данных 50 тестовых
     * организаций.
     * Также создает 10 филиалов, связывая их с организациями.
     */
    @PostConstruct
    public void createOrganizations() {
        List<Organization> organizations = new ArrayList<>();
        List<Branch> branches = new ArrayList<>();

        log.info("Создание 50 тестовых организаций и 10 тестовых филиалов");

        for (int i = 1; i <= 50; i++) {
            Organization organization = new Organization();
            String str = String.valueOf(i);

            organization.setFullName("Organization " + str);
            organization.setShortName("Org" + str);
            organization.setInn(111111111111L + i);
            organization.setOgrn(1111111111111L + i);
            organization.setPostalAddress("postalAddress " + str);
            organization.setLegalAddress("legalAddress " + str);
            organization.setCeoFirstName("ceoFirstName " + str);
            organization.setCeoLastName("ceoLastName " + str);
            organization.setCeoMiddleName("ceoMiddleName " + str);
            organization.setCeoBD(generateRandomDate(1970, 1990));

            organizations.add(organization);
        }

        for (int i = 1; i <= 10; i++) {
            Branch branch = new Branch();
            String str = String.valueOf(i);

            branch.setOrganization(organizations.get(0));
            branch.setName("Branch " + str);
            branch.setPostalAddress("postalAddress " + str);
            branch.setHeadFirstName("headFirstName " + str);
            branch.setHeadLastName("headLastName " + str);
            branch.setHeadMiddleName("headMiddleName " + str);
            branch.setHeadBD(generateRandomDate(1975, 1995));

            if (i <= 4) {
                branch.setOrganization(organizations.get(0));
            } else if (i <= 6) {
                branch.setOrganization(organizations.get(1));
            } else if (i <= 9) {
                branch.setOrganization(organizations.get(2));
            } else {
                    branch.setOrganization(organizations.get(49));
                }

            branches.add(branch);

        }


        organizationRepository.saveAll(organizations);
        log.info("Организации сохранены в БД");
        branchRepository.saveAll(branches);
        log.info("Филиалы сохранены в БД");
    }

    /**
     * Генерирует случайную дату между startYear и endYear.
     * @param startYear начальный год
     * @param endYear конечный год
     */
    private Date generateRandomDate(int startYear, int endYear) {
        long startEpochDay = LocalDate.of(startYear, 1, 1).toEpochDay();
        long endEpochDay = LocalDate.of(endYear, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return Date.from(randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Получает список всех организаций.
     */
    @Override
    public List<Organization> getAllOrganizations() {
        log.info("Список всех организаций: ");
        return organizationRepository.findAll();
    }

    /**
     * Выполняет поиск организаций по фильтру.
     * @param search Строка для поиска по фильтру
     */
    @Override
    public List<Organization> searchOrganizations(String search) {
        log.info("Организации, подходящие по фильтру: {} ", search);
        return organizationRepository.findByFullNameContainingIgnoreCaseOrPostalAddressIgnoreCaseOrCeoLastNameIgnoreCase
                (search, search, search);
    }

    /**
     * Получает организацию по её идентификатору.
     * @param id Идентификатор организации
     */
    @Override
    public Optional<Organization> getOrganizationById(int id) {
        log.info("Организация с идентификатором {}: ", id);
        return organizationRepository.findById(id);
    }
}