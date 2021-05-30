package com.amartek.halodunia.service;

import java.util.List;
import java.util.Optional;

import com.amartek.halodunia.entity.Buku;
import com.amartek.halodunia.repository.BukuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRespository;

    public List<Buku> getAll(){
        return bukuRespository.findAll();
    }

    public List<Buku> getBukuByJudul(String judul, Long idBuku){
        Optional<Buku> bukuOptional = bukuRespository.findById(idBuku);

        if(bukuOptional.isPresent()){
             return bukuRespository.findByJUDULIgnoreCase(judul);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found!");
        }
    }

    public Buku getBukuByID(Long id){
       if(!bukuRespository.findById(id).isPresent()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching ID was found!");
       }
       return bukuRespository.findById(id).get();
    }

    
    public List<Buku> getBukuByJudul(String judul){
        return bukuRespository.findByJUDULContainsIgnoreCase(judul);
    }

    public void addBuku(Buku buku){
        Optional<Buku> bukuOptional = bukuRespository.findByISBN(buku.getISBN());

        if(bukuOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book with same ISBN is available!");
        }
        else{
            bukuRespository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book data Successfully saved!");
        }
    }

    public void editBuku(Long idBuku, Buku buku){
        Optional<Buku> bukuOptional = bukuRespository.findById(idBuku);

        if(bukuOptional.isPresent()){
            bukuRespository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Update!");
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not available!");
        }
    }

    public void deleteBuku(Long idBuku){
        Optional<Buku> bukuOptional = bukuRespository.findById(idBuku);

        if(bukuOptional.isPresent()){
            bukuRespository.deleteById(idBuku);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Deleted!");
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not Available!");
        }
    }
}
