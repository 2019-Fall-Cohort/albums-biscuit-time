package org.wcci.albums;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	@GetMapping("")
	public List<Artist> fetchAll() {
		return (List<Artist>) artistService.findAllArtists();
	}
	
	@GetMapping("/{id}")
	public Artist fetchById(@PathVariable long id) {
		return artistService.fetchArtist(id);
		
	}
	
	@PatchMapping("/{id}/add-comment")
	public Artist addComment(@PathVariable long id, @RequestBody Comment comment) {
		Artist artist = artistService.fetchArtist(id);
		artist.addComment(comment);
		return artistService.saveArtist(artist);
	}
	
	
}
