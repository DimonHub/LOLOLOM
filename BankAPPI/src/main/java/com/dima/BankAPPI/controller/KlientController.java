package com.dima.BankAPPI.controller;

import com.dima.BankAPPI.entity.Klient;
import com.dima.BankAPPI.service.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klients")
public class KlientController {

    private final KlientService klientService;

    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping
    public List<Klient> getAllKlients() {
        return klientService.getAllKlients();
    }

    @GetMapping("/{id}")
    public Optional<Klient> getKlientById(@PathVariable Long id) {
        return klientService.getKlientById(id);
    }

    @PostMapping
    public Klient createKlient(@RequestBody Klient klient) {
        return klientService.saveKlient(klient);
    }

    @DeleteMapping("/{id}")
    public void deleteKlient(@PathVariable Long id) {
        klientService.deleteKlient(id);
    }
}
