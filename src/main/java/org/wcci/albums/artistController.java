package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artists")
public class artistController {

	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumRepository albumRepo;
	
	@GetMapping("")
	public Iterable<Artist> fetchAllArtists() {
		return artistRepo.findAll();
	}
}
