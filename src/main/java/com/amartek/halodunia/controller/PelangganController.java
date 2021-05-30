package com.amartek.halodunia.controller;

import java.util.List;

import com.amartek.halodunia.entity.Pelanggan;
import com.amartek.halodunia.service.PelangganService;

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
@RequestMapping("/pelanggan")
public class PelangganController {
    
    private final PelangganService pelangganService;


    public PelangganController(PelangganService pelangganService) {
        this.pelangganService = pelangganService;
    }

    @GetMapping("/gets-pelanggan")
    public List<Pelanggan> getAll(){
        return pelangganService.getAll();
    }

    @GetMapping("/get-pelanggan/{idPelanggan}/{namaPelanggan}")
    public List<Pelanggan> getPelanggan(@PathVariable final Long idPelanggan, @PathVariable final String namaPelanggan){
        return pelangganService.getPelangganByNama(namaPelanggan, idPelanggan);
    }

    @GetMapping("/get-pelanggan/{namaPelanggan}")
    public List<Pelanggan> getPelanggan(@PathVariable final String namaPelanggan){
        return pelangganService.getPelangganByNama(namaPelanggan);
    }

    @GetMapping("/get-pelanggan-withkode/{kodePelanggan}/{namaPelanggan}")
    public List<Pelanggan> getPelanggan(@PathVariable final String kodePelanggan, @PathVariable final String namaPelanggan){
        return pelangganService.getPelangganByNama(namaPelanggan, kodePelanggan);
    }

    @PostMapping("/add")
    public void addPelanggan(@RequestBody final Pelanggan pelanggan){
        pelangganService.addPelanggan(pelanggan);
    }

    @PutMapping("/edit/{idPelanggan}")
    public void editPelanggan(@PathVariable final Long idPelanggan, @RequestBody final Pelanggan pelanggan){
        pelangganService.editPelanggan(idPelanggan, pelanggan);
    }

    @DeleteMapping("/delete/{idPelanggan}")
    public void deletePelanggan(@PathVariable final Long idPelanggan){
        pelangganService.deletePelanggan(idPelanggan);
    }

    //testing branch push







}
