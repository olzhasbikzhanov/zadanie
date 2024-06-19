package com.example.zadanie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Класс, представляющий филиал организации.
 * Содержит информацию о филиале, включая организацию, к которой он относится.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branches")
public class Branch {

    /**
     * Уникальный идентификатор филиала. Генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Организация, к которой относится филиал.
     * Используется аннотация @JsonBackReference для предотвращения циклических ссылок при сериализации.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    @JsonBackReference
    private Organization organization;

    /**
     * Название филиала.
     */
    private String name;

    /**
     * Почтовый адрес филиала.
     */
    private String postalAddress;

    /**
     * Имя руководителя филиала.
     */
    private String headFirstName;

    /**
     * Фамилия руководителя филиала.
     */
    private String headLastName;

    /**
     * Отчество руководителя филиала.
     */
    private String headMiddleName;

    /**
     * Дата рождения руководителя филиала.
     */
    @Column(name = "head_bd")
    private Date headBD;
}
