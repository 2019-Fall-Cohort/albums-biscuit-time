package org.wcci.albums;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class SongController {
	
	private SongRepository songRepo;

	@GetMapping("")
	public List<Song> fetchAll() {
		return (List<Song>) songRepo.findAll();
	}

}