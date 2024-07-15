package com.youtube.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServer {
    @Autowired
    PlaylistRepository repository;

    @Autowired
    FeignCommunicator feignCommunicator;

    public Playlist implementFindByID(int id){
        Playlist obj = repository.findById(id).orElse(new Playlist());
        if(obj!=null){
            obj.setMyVideos(feignCommunicator.callVideos(obj.getPlaylistId()));
        }
        return obj;
    }

    public List<Playlist> implementFindAll(){
        return repository.findAll();
    }

    public Playlist implementSave(Playlist playlist){
        return repository.save(playlist);
    }
}
