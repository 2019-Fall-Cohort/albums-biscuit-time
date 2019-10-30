package org.wcci.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.models.Song;
import org.wcci.albums.repositories.SongRepository;

@Repository
public class SongService {

	@Autowired
	SongRepository songRepo;
	
	public void addSong(Song songToAdd) {
		songRepo.save(songToAdd);
	}
	
	public Song findSong(Long id) {
		return songRepo.findById(id).get();
	}
	
	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}
}
