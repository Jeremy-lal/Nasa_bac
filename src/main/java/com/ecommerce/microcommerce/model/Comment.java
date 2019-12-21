package com.ecommerce.microcommerce.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createAt;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="comment_id", nullable=false)
    private Comment parent;
    
    @OneToMany(mappedBy="parent")
    private Set<Comment> comments;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Comment() {
    }
    
    public Comment(int id, User user, String title, String content, Date createAt) {
        this.id = id;
        this.user = user;
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
    public User getuser() {
        return user;
    }

    public User setuser(User user) {
        return this.user = user;
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
    ///////////////////
    ////////////
    public Set<Comment> getcomment() {
        return comments;
    }

    public void setcomments(Set<Comment> comments) {
        this.comments = comments;
    }
    ///////////////////

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", user='" + user + ", comments='" + comments + ", title='" + title + ", createAt='" + createAt + ", content='" + content + '}';
    }
}
