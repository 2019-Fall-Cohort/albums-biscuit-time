package org.wcci.albums.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.models.Artist;
import org.wcci.albums.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository artistRepo;
	

	public Artist addArtist(Artist artistToAdd) {
		return artistRepo.save(artistToAdd);

	}

	public Artist findArtist(Long id) {
		return artistRepo.findById(id).get();
	}

	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}

	public Artist fetchArtist(long id) {
//		Optional<Artist> retrieveArtistOptional = artistRepo.findById(id);
	 return artistRepo.findById(id).get();
			 
//		if (!retrievedArtistOptional.isPresent()) {
//			throw new ArtistNotFoundExceptional("Artist not Found.");
//		}
//		return retrievedArtistOptional.get;
	}

	public Artist saveArtist(Artist artist) {
		return artistRepo.save(artist);
	}
	
	
	

}
