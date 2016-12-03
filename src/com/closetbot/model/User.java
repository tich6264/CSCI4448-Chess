package com.closetbot.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Owner on 11/2/2016.
 */
@Entity
@Table(name="user")
public class User {

    @Column(name="username")
    private String       username;
    @Column(name="password")
    private String       password;
    @Column(name="firstName")
    private String       firstName;
    @Column(name="lastName")
    private String       lastName;
    @Column(name="gender")
    private Gender       gender;
    @Column(name="closet") @Lob
    @org.hibernate.annotations.Type(type = "serializable")
    private Closet       closet;
    @Column(name="outfits") @Lob
    @org.hibernate.annotations.Type(type = "serializable")
    private OutfitCloset outfits;
    @Id @GeneratedValue
    @Column(name="id")
    private int       id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Closet getCloset() {
        return closet;
    }

    public void setCloset(Closet closet) {
        this.closet = closet;
    }
    public OutfitCloset getOutfits() {
        return outfits;
    }

    public void setOutfits(OutfitCloset outfits) {
        this.outfits = outfits;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}