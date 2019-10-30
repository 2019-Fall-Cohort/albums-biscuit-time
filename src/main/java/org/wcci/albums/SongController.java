package org.wcci.albums;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class SongController {
	
	private SongService songService;

	@GetMapping("")
	public List<Song> fetchAll() {
		return (List<Song>) songService.findAllSongs();
	}

	@GetMapping("/{id}")
	public Song fetchById(@PathVariable Long id) {
		return songService.findSong(id);
	}

}
