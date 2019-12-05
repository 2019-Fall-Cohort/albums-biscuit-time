package org.wcci.albums.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.exceptions.AlbumNotFoundException;
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
		Optional<Album> retrievedAlbumOptional = albumRepo.findById(id);
		if (!retrievedAlbumOptional.isPresent()) {
			throw new AlbumNotFoundException("Album not found.");
		}
		return retrievedAlbumOptional.get();
	}

	public List<Album> fetchAllAlbums() {
		return (List<Album>) albumRepo.findAll();
	}

}
