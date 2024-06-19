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
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    /**
     * Поиск организаций по частичному совпадению в полном наименовании, полном совпадении в почтовом адресе
     * и фамилии генерального директора, игнорируя регистр символов.
     * @param fullName     Часть полного наименования организации для поиска
     * @param postalAddress Почтовый адрес для поиска
     * @param ceoLastName  Фамилия генерального директора для поиска
     */
    List<Organization> findByFullNameContainingIgnoreCaseOrPostalAddressIgnoreCaseOrCeoLastNameIgnoreCase
            (String fullName, String postalAddress, String ceoLastName);

}
