package com.amartek.halodunia.controller;

import java.util.List;

import com.amartek.halodunia.entity.Buku;
import com.amartek.halodunia.service.BukuService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/buku")
public class BukuController {

    private final BukuService bukuService;
    

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }
    
    @GetMapping("/gets")
    public List<Buku> getAll(){
        return bukuService.getAll();
    }

    @GetMapping("/get-buku/{idBuku}/{judulBuku}")
    public List<Buku> getBuku(@PathVariable final Long idBuku, @PathVariable final String judulBuku){
        return bukuService.getBukuByJudul(judulBuku, idBuku);
    }

    @GetMapping("/get-by-judul/{judulBuku}")
    public List<Buku> getBuku(@PathVariable final String judulBuku){
        return bukuService.getBukuByJudul(judulBuku);
    }

    @GetMapping("/get-by-id/{idBuku}")
    public Buku getBukuById(@PathVariable final Long idBuku){
        return bukuService.getBukuByID(idBuku);
    }

    @PostMapping("/add")
    public void addBuku(@RequestBody final Buku buku){
       bukuService.addBuku(buku);
    }

    @PutMapping("/edit/{idBuku}")
    public void editBuku(@PathVariable final Long idBuku, @RequestBody final Buku buku){
       bukuService.editBuku(idBuku, buku);
    }

    @DeleteMapping("/delete/{idBuku}")
    public void deleteBuku(@PathVariable final Long idBuku){
      bukuService.deleteBuku(idBuku);
    }


}
