package com.framework.contatos.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.contatos.domain.Contato;

@RestController
@RequestMapping("/api/contato")
public class ContatosController {

    private static List<Contato> contatos = new ArrayList<>();

    static {
        contatos.add(new Contato("Gustavo", "gustavo@mail.com"));
        contatos.add(new Contato("Marcos", "marcos@mail.com"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Contato>> findAll() {
        return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Contato> create(Contato contato) {
        contatos.add(contato);
        return new ResponseEntity<Contato>(HttpStatus.OK);
    }
}
