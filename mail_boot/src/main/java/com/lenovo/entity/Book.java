package com.lenovo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String author;


}
