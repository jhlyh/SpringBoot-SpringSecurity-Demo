package com.jhlyh.spring_bootdemo.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jhlyh
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@RequiredArgsConstructor

public class Ingredient {

    @Id
    private final Integer id;

    private final String name;
}
