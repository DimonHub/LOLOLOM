package com.dima.BankAPPI.service;

import com.dima.BankAPPI.entity.Klient;
import com.dima.BankAPPI.repository.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlientService {

    private final KlientRepository klientRepository;

    @Autowired
    public KlientService(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    public List<Klient> getAllKlients() {
        return klientRepository.findAll();
    }

    public Optional<Klient> getKlientById(Long id) {
        return klientRepository.findById(id);
    }

    public Klient saveKlient(Klient klient) {
        return klientRepository.save(klient);
    }

    public void deleteKlient(Long id) {
        klientRepository.deleteById(id);
    }
}
