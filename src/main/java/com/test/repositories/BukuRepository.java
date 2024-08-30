package com.test.repositories;

import com.test.entities.Buku;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BukuRepository extends JpaRepository<Buku, Long> {

}
