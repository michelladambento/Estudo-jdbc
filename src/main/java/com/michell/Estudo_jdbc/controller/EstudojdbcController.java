package com.michell.Estudo_jdbc.controller;

import com.michell.Estudo_jdbc.entities.Produto;
import com.michell.Estudo_jdbc.service.EstudojdbcService;
import com.michell.Estudo_jdbc.service.EstudojdbcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class EstudojdbcController {

    @Autowired
    private EstudojdbcService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAllProducts(){
        List<Produto> allProdutc = service.findAllProdutc();
        return ResponseEntity.ok(allProdutc);
    }

}
