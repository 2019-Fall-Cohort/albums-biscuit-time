package org.wcci.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.wcci.albums.models.Song;
import org.wcci.albums.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	SongRepository songRepo;
	
	public Song saveSong(Song song) {
		return songRepo.save(song);
	}
	
	public Song fetchSong(Long id) {
		return songRepo.findById(id).get();
	}
	
	public List<Song> fetchAllSongs() {
		return (List<Song>)songRepo.findAll();
	}
}
