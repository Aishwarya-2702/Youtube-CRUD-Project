package com.youtube.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistMapping {
    @Autowired
    private PlaylistService service;

    @GetMapping("/byProfile/{proId}")
    public List<Playlist> callByPro(@PathVariable("proId") int proId){
        return service.implementFindPro(proId);
    }

    @GetMapping("/{id}")
    public Playlist fetchOne(@PathVariable("id") int id){
        return service.implementFindById(id);
    }

    @PutMapping("/")
    public Playlist progress(@RequestBody Playlist playlist){
        return service.implementSave(playlist);
    }

    @DeleteMapping("/{id}")
    public String discharge(@PathVariable("id") int id){
        service.implementDelete(id);
        return id+" has removed";
    }

    @GetMapping("/")
    public List<Playlist> viewAll(){
        return service.implementFindAll();
    }

    @PostMapping("/")
    public Playlist ip(@RequestBody Playlist playlist){
        return service.implementSave(playlist);
    }
}
