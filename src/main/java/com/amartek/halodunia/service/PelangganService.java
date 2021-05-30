package com.amartek.halodunia.service;

import java.util.List;
import java.util.Optional;

import com.amartek.halodunia.entity.Pelanggan;
import com.amartek.halodunia.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
    
    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAll(){
        return pelangganRepository.findAll();
    }

    public List<Pelanggan> getPelangganByNama(String nama, Long idPelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(idPelanggan);

        if(pelangganOptional.isPresent()){
            return pelangganRepository.findByNAMAIgnoreCase(nama);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name Pelanggan dan idPelanggan Not Found!");        
        }
    }

    public List<Pelanggan> getPelangganByNama(String nama){
        return pelangganRepository.findByNAMAContainsIgnoreCase(nama);
    }

    public List<Pelanggan> getPelangganByNama(String nama, String kodePel){
        List<Pelanggan> pelangganList = pelangganRepository.findByKODEPELContainsIgnoreCase(kodePel);

        if(pelangganList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name Pelanggan dan Kode Pelanggan Not Found!");
        }
        else{
            return pelangganRepository.findByNAMAContainsIgnoreCase(nama);
        }
    }

    public void addPelanggan(Pelanggan pelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByTELP(pelanggan.getTELP());
        
        if(pelangganOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Pelanggan with same Telp is availlable!");
        }else{
            pelangganRepository.save(pelanggan);
            throw new ResponseStatusException(HttpStatus.OK, "Pelanggan Data Successfully saved!");
        }
    }

    public void editPelanggan(Long idPelanggan, Pelanggan pelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(idPelanggan);

        if(pelangganOptional.isPresent()){
            pelangganRepository.save(pelanggan);
            throw new ResponseStatusException(HttpStatus.OK, "Pelanggan has successfully been Update!");
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelanggan is not availablel!");
        }

    }

    public void deletePelanggan(Long idPelanggan){
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(idPelanggan);

        if(pelangganOptional.isPresent()){
            pelangganRepository.deleteById(idPelanggan);
            throw new ResponseStatusException(HttpStatus.OK, "Pelanggan has successfully been Deleted!");
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelanggan is not Available!");
        }

    }



}
