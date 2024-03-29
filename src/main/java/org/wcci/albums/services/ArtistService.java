package org.wcci.albums.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.exceptions.ArtistNotFoundException;
import org.wcci.albums.models.Artist;
import org.wcci.albums.repositories.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	ArtistRepository artistRepo;

	public Artist saveArtist(Artist artist) {
		return artistRepo.save(artist);
	}
	
	public void deleteArtist(Artist artist) {
		artistRepo.delete(artist);
	}

	public Artist fetchArtist(Long id)  {
		Optional<Artist> retrievedArtistOptional = artistRepo.findById(id);
		if (!retrievedArtistOptional.isPresent()) {
			throw new ArtistNotFoundException("Artist not found.");
		}
		return retrievedArtistOptional.get();
	}

	public List<Artist> fetchAllArtists() {
		return (List<Artist>) artistRepo.findAll();
	}

}
