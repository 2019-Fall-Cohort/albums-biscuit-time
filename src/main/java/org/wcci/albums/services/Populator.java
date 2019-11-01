package org.wcci.albums.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Song;
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.repositories.SongRepository;
@Component
public class Populator implements CommandLineRunner{
	
	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private SongRepository songRepo;
//	@Autowired
//	private TagService tagService;
	
	@Override
	public void run(String... args) throws Exception {
		Artist artist = new Artist("David Bowie");
		artistRepo.save(artist);

		Album album = new Album("Diamond Dogs", artist);
		albumRepo.save(album);
		
		Song song = new Song("Rebel Rebel", album);
		Song song2 = new Song("Diamond Dogs", album);
		songRepo.save(song);
		songRepo.save(song2);
		
		
	}
	

}
