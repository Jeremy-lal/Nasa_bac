package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.CommentRepo;
import com.ecommerce.microcommerce.model.Comment;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
public class CommentController {

    @Autowired
    private CommentRepo CommentRepo;

    // Récupérer la liste des produits
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public MappingJacksonValue listeComment() {
        Iterable<Comment> produits = CommentRepo.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    // Poster un Comment
    @CrossOrigin
    @PostMapping(value = "/comments")
    public ResponseEntity<Void> addComment(@RequestBody Comment Comment) {
        Comment CommentAdded = CommentRepo.save(Comment);
        if (CommentAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(CommentAdded.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/comments/{id}")
    public void deleteComment(@PathVariable int id) {
        CommentRepo.deleteById(id);
    }

    @PutMapping(value = "/comments")
    public void updateComment(@RequestBody Comment Comment) {
        CommentRepo.save(Comment);
    }
}
