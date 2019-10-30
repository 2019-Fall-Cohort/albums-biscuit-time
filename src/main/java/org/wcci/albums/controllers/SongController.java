package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Comment;
import org.wcci.albums.models.Song;
import org.wcci.albums.services.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {
	
	private SongService songService;

	@GetMapping("")
	public List<Song> fetchAll() {
		return (List<Song>) songService.fetchAllSongs();
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

}
