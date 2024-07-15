package com.youtube.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoMapping {
    @Autowired
    private VideoService service;

    @GetMapping("/byPlaylist/{plyId}")
    public List<Video> callByPly(@PathVariable("plyId") int plyId){
        return service.implementFindPly(plyId);
    }

    @GetMapping("/{id}")
    public Video fetchOne(@PathVariable("id") int id){
        return service.implementFindById(id);
    }

    @PutMapping("/")
    public Video progress(@RequestBody Video video){
        return service.implementSave(video);
    }

    @DeleteMapping("/{id}")
    public String discharge(@PathVariable("id") int id){
        service.implementDelete(id);
        return id+" has removed";
    }

    @GetMapping("/")
    public List<Video> viewAll(){
        return service.implementFindAll();
    }

    @PostMapping("/")
    public Video ip(@RequestBody Video video){
        return service.implementSave(video);
    }
}
