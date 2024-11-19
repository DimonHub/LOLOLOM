package com.dima.BankAPPI.repository;

import com.dima.BankAPPI.entity.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {

}
