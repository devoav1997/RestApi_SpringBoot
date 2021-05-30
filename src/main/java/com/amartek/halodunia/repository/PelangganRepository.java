package com.amartek.halodunia.repository;

import java.util.List;
import java.util.Optional;

import com.amartek.halodunia.entity.Pelanggan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
    List<Pelanggan> findByNAMAIgnoreCase(String nama);

    List<Pelanggan> findByNAMAContainsIgnoreCase(String nama);

    List<Pelanggan> findByKODEPELContainsIgnoreCase(String kodePel);

    Optional<Pelanggan> findByTELP(String telp);

}
