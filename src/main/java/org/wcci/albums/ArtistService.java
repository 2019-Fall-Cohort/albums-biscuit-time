package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepo;
	
	public void addArtist(Artist artistToAdd) {
		artistRepo.save(artistToAdd);
	}

	public Artist findArtist(Long id) {
		return artistRepo.findById(id).get();
	}

	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}
	

}