package com.ecommerce.microcommerce.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @JsonIgnoreProperties(value = {"prixAchat", "id"})    si plusieur chose a cacher
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String pseudo;
    private String email;
    private Boolean status;
    private String imgURL;

    // information que nous ne souhaitons pas exposer
    @JsonIgnore
    private String pwd;

    @OneToMany(mappedBy="user")
    private Set<Comment> comments;

    public User() {
    }

    public User(int id, String pseudo, String email, Boolean status, String imgURL, String pwd) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.status = status;
        this.imgURL = imgURL;
        this.pwd = pwd;
    }
    
    //////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /////////////
    public String getpseudo() {
        return pseudo;
    }

    public void setpseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /////////
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    ////////////

    public Boolean getstatus() {
        return status;
    }

    public void setstatus(Boolean status) {
        this.status = status;
        ;
    }

    ////////////
    public String getimgURL() {
        return imgURL;
    }

    public void setimgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    ////////////
    public String getpwd() {
        return pwd;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;;
    }

    ////////////
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", pseudo='" + pseudo + ", email='" + email + ", status='" + status + ", imgURL='" + imgURL + ", pwd='" + pwd +'}';
    }
}
