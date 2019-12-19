package com.ecommerce.microcommerce.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.dao.support.DaoSupport;

// @JsonIgnoreProperties(value = {"prixAchat", "id"})    si plusieur chose a cacher
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;
    private int user_id;
    private Date createAt;
    private String title;
    private String content;


    public Comment() {
    }

    public Comment(int id, int user_id, String title, String content, Date createAt) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.createAt = createAt;
        this.content = content;
    }

    //////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /////////////
    public int getuserId() {
        return user_id;
    }

    public void setuserId(int user_id) {
        this.user_id = user_id;
    }

    /////////
    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }
    ////////////

    public Date getcreateAt() {
        return createAt;
    }

    public void setstatus(Date createAt) {
        this.createAt = createAt;
        ;
    }

    ////////////
    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", user_id='" + user_id + ", title='" + title + ", createAt='" + createAt + ", content='" + content + '}';
    }
}
