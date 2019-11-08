package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Comment;
import org.wcci.albums.models.Tag;
import org.wcci.albums.repositories.TagRepository;
import org.wcci.albums.services.AlbumService;
import org.wcci.albums.services.ArtistService;

@CrossOrigin
@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private TagRepository tagRepo;

	@GetMapping("")
	public List<Artist> fetchAll() {
		return artistService.fetchAllArtists();
	}
	
	@GetMapping("/{id}/albums")
	public List<Album> fetchAllAlbums(@PathVariable Long id) {
		return albumService.fetchAllAlbums();
	}

	@PostMapping("")
	public Artist addArtist(@RequestBody Artist artist) {
		return artistService.saveArtist(artist);
	}

	@PatchMapping("/{id}/add-tag")
	public Artist addTag(@PathVariable Long id, @RequestBody Tag tag) {
		Artist artist = artistService.fetchArtist(id);
		tag.addArtist(artist);
		tagRepo.save(tag);
		return artistService.fetchArtist(id);
	}

	@GetMapping("/{id}")
	public Artist fetchArtist(@PathVariable long id) {
		return artistService.fetchArtist(id);

	}

	@PatchMapping("/{id}/add-comment")
	public Artist addComment(@PathVariable long id, @RequestBody Comment comment) {
		Artist artist = artistService.fetchArtist(id);
		artist.addComment(comment);
		return artistService.saveArtist(artist);
	}

}
