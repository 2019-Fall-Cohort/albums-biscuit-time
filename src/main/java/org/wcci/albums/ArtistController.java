package org.wcci.albums;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Autowired
	private ArtistRepository artistRepo;

	
	@GetMapping("")
	public List<Artist> fetchAll() {
		return (List<Artist>) artistRepo.findAll();
	}
	
	public Artist fetchById(@PathVariable long id) {
		return artistService.fetchArtist(id);
		
	}
}
