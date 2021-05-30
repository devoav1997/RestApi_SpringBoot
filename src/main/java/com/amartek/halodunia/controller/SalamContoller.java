package com.amartek.halodunia.controller;

import com.amartek.halodunia.entity.Salam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalamContoller {
    private Integer counter = 0;

    @GetMapping("/salam")
    public String salam(){
        return "Salam...!";
    }


    @GetMapping("/salam-nama")
    public Salam salam(@RequestParam(name = "nama", defaultValue = "Manusia") final String nama){
        // return String.format("Salam , %s!", nama);
        return new Salam((long)counter++, String.format("Salam , %s!", nama));
    }

    @GetMapping("/salam-id")
    public String salam(@RequestParam(name = "id", defaultValue = "1") final Integer Id){
        return String.format("Salam, entitas dengan ID = %s", Id.toString());
    }

    @GetMapping("/salam/{nama}")
    public String salamUntukmu(@PathVariable final String nama){
        return String.format("Salam , %s!", nama);
    }

 
}
