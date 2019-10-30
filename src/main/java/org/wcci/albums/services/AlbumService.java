package org.wcci.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.models.Album;
import org.wcci.albums.repositories.AlbumRepository;

@Repository
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepo;
	
	public void addAlbum(Album albumToAdd) {
		albumRepo.save(albumToAdd);
	}

	public Album findAlbum(Long id) {
		return albumRepo.findById(id).get();
	}

	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}
	
	
	

}
