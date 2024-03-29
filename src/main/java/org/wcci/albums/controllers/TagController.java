package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Song;
import org.wcci.albums.models.Tag;
import org.wcci.albums.repositories.TagRepository;

@CrossOrigin
@RestController
@RequestMapping ("/api/tags")
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	@GetMapping("")
	public Iterable<Tag> fetchAll() {
		return tagRepo.findAll();
	}
	
	@GetMapping("/{id}")
    public Tag fetchIndividualTag(@PathVariable Long id){
        return tagRepo.findById(id).get();
    }
    @GetMapping("/{id}/albums")
    public Iterable<Album> fetchTagAlbums(@PathVariable Long id){
        return tagRepo.findById(id).get().getAlbums();
    }
    @GetMapping("{id}/artists")
    public Iterable<Artist> fetchTagArtists(@PathVariable Long id){
        return tagRepo.findById(id).get().getArtists();
    }
    @GetMapping("{id}/songs")
    public Iterable<Song> fetchTagSongs(@PathVariable Long id){
        return tagRepo.findById(id).get().getSongs();
    }


}
