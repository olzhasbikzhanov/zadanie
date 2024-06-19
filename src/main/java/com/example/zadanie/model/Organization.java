package com.example.zadanie.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Класс, представляющий организацию.
 * Содержит информацию об организации, включая филиалы, связанные с ней.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations")
public class Organization {

    /**
     * Уникальный идентификатор организации. Генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Полное название организации.
     */
    private String fullName;

    /**
     * Краткое название организации.
     */
    private String shortName;

    /**
     * Идентификационный номер налогоплательщика (ИНН).
     */
    private Long inn;

    /**
     * Основной государственный регистрационный номер (ОГРН).
     */
    private Long ogrn;

    /**
     * Почтовый адрес организации.
     */
    private String postalAddress;

    /**
     * Юридический адрес организации.
     */
    private String legalAddress;

    /**
     * Имя генерального директора организации.
     */
    private String ceoFirstName;

    /**
     * Фамилия генерального директора организации.
     */
    private String ceoLastName;

    /**
     * Отчество генерального директора организации.
     */
    private String ceoMiddleName;

    /**
     * Дата рождения генерального директора организации.
     */
    @Column(name = "ceo_bd")
    private Date ceoBD;

    /**
     * Список филиалов, принадлежащих организации.
     * Используется аннотация @JsonManagedReference для предотвращения циклических ссылок при сериализации.
     */
    @OneToMany(mappedBy = "organization")
    @JsonManagedReference
    private List<Branch> branches;
}
