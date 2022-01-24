package com.example.MyPrdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;
    String surname;
    String city;
    String phone;
    String mail;

    public Friend() {};

    public Friend(String name, String surname, String city, String phone, String mail) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
    }
    public Friend(long id, String name, String surname, String city, String phone, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.phone = phone;
        this.mail = mail;
    }
}
