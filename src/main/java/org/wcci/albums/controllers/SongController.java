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

import org.wcci.albums.models.Album;

import org.wcci.albums.models.Artist;

import org.wcci.albums.models.Comment;
import org.wcci.albums.models.Song;
import org.wcci.albums.models.Tag;
import org.wcci.albums.repositories.TagRepository;
import org.wcci.albums.services.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

	@Autowired
	private SongService songService;
	@Autowired
	private TagRepository tagRepo;

	@GetMapping("")
	public List<Song> fetchAll() {
		return songService.fetchAllSongs();
	}
	
	@PostMapping("")
	public Song addSong(@RequestBody Song song) {
		return songService.saveSong(song);
	}

	@GetMapping("/{id}")
	public Song fetchById(@PathVariable Long id) {
		return songService.fetchSong(id);
	}

	@PatchMapping("/{id}/add-comment")
	public Song addComment(@PathVariable long id, @RequestBody Comment comment) {
		Song song = songService.fetchSong(id);
		song.addComment(comment);
		return songService.saveSong(song);
	}

	@PatchMapping("/{id}/add-tag")
	public Song addTag(@PathVariable Long id, @RequestBody Tag tag) {
		Song song = songService.fetchSong(id);
		tag.addSong(song);
		tagRepo.save(tag);
		return songService.fetchSong(id);
	}

}
