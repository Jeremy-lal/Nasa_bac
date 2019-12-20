package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.UserRepo;
import com.ecommerce.microcommerce.model.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo UserRepo;

    // Récupérer la liste des produits
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public MappingJacksonValue listeProduits() {
        Iterable<User> produits = UserRepo.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    // Récupérer un utilisateur par son Id
    @GetMapping(value = "/users/{id}")
    public User showUser(@PathVariable int id) {
        return UserRepo.findById(id);
    }

    // Poster un user
    @PostMapping(value = "/users")
    public ResponseEntity<Void> addUser(@RequestBody User User) {
        User UserAdded = UserRepo.save(User);
        if (UserAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(UserAdded.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        UserRepo.deleteById(id);
    }

    @PutMapping(value = "/users")
    public void updateUser(@RequestBody User User) {
        UserRepo.save(User);
    }
}
