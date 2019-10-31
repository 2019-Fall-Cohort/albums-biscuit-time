package org.wcci.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.models.Artist;
import org.wcci.albums.repositories.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	ArtistRepository artistRepo;

	public Artist saveArtist(Artist artist) {
		return artistRepo.save(artist);

	}

	public Artist fetchArtist(Long id) {
		return artistRepo.findById(id).get();
	}

	public List<Artist> fetchAllArtists() {
		return (List<Artist>) artistRepo.findAll();
	}

}
