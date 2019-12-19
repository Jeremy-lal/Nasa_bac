package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.microcommerce.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {


}

