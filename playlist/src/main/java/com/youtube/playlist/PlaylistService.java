package com.youtube.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRemote remote;

    public List<Playlist> implementFindPro(int proId){
        return remote.findAllByProfileId(proId);
    }

    public Playlist implementFindById(int playlistID){
        return remote.findById(playlistID).orElse(new Playlist());
    }

    public void implementDelete(int id){
        remote.deleteById(id);
    }

    public List<Playlist> implementFindAll(){
        return remote.findAll();
    }

    public Playlist implementSave(Playlist playlist){
        return remote.save(playlist);
    }
}
