package com.youtube.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/getplaylist")
public class PlaylistController {
    @Autowired
    PlaylistServer server;

    @PostMapping("/")
    public Playlist callSave(@RequestBody Playlist playlist){
        return server.implementSave(playlist);
    }

    @GetMapping("/{id}")
    public Playlist callOne(@PathVariable("id") int id){
        return server.implementFindByID(id);
    }

    @GetMapping("/")
    public List<Playlist> callFetch(){
        return server.implementFindAll();
    }
}
