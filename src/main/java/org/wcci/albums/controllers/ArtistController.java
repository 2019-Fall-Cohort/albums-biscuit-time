package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.Tag;
import org.wcci.albums.TagRepository;
import org.wcci.albums.models.Artist;
import org.wcci.albums.services.ArtistService;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	@Autowired
	private TagRepository tagRepo;
	
	
	@GetMapping("")
	public List<Artist> fetchAll() {
		return (List<Artist>) artistService.findAllArtists();
	}
	
	@PostMapping("")
	public Artist addArtist(@RequestBody Artist artistToAdd) {
		return artistService.addArtist(artistToAdd);
	}

	@PatchMapping("/{id}/addTag")
	public Artist addTag(@PathVariable Long id,@RequestBody Tag tagToAdd) {
		Artist artistToAdd = artistService.findArtist(id);
		tagToAdd.addArtist(artistToAdd);
		tagRepo.save(tagToAdd);
		return artistService.findArtist(id);
	}
}
