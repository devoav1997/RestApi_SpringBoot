package com.amartek.halodunia.repository;

import java.util.List;
import java.util.Optional;

import com.amartek.halodunia.entity.Buku;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByJUDULIgnoreCase(String judul);
    
    List<Buku> findByJUDULContainsIgnoreCase(String judul);

    Optional<Buku> findByISBN(String ISBN);

}
