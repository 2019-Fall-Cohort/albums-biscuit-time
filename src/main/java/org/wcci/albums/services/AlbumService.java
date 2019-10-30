package org.wcci.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.models.Album;
import org.wcci.albums.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepo;
	
	public Album saveAlbum(Album album) {
		return albumRepo.save(album);
	}

	public Album fetchAlbum(Long id) {
		return albumRepo.findById(id).get();
    }
	
	public List<Album> fetchAllAlbums() {
		return (List<Album>) albumRepo.findAll();
	}

	}
	
	
	


