package org.wcci.albums.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Song;
import org.wcci.blog.Tag;

public class Populator implements CommandLineRunner{
	
	@Autowired
	private ArtistService artistService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private SongService songService;
//	@Autowired
//	private TagService tagService;
	
	List<String> artists = Arrays.asList("Bob Dylan", "David Bowie");
	List<String> albums = Arrays.asList("Blonde on Blonde", "Diamond Dogs");
	List<String> songs = Arrays.asList("Rainy Day Woman", "Rebel Rebel");
	List<String> tags = Arrays.asList("folk", "glam");


	@Override
	public void run(String... args) throws Exception {
		generateArtist();
		generateAlbum();
		generateSong();
//		generateTag();
	}
//private void generateTag() {
//		for (String tagName : tags) {
//		Tag tag = new Tag(tagName);
//		tagStorage.addTag(tag);
//		
//	}
private void generateSong() {
	for (String songName : songs) {
		Song song = new Song(songName, null);
		songService.saveSong(song);
	}
		
	}
private void generateAlbum() {
	for (String albumName : albums) {
		Album album = new Album(albumName, null);
		albumService.saveAlbum(album);
	}
}
private void generateArtist() {
	for (String artistName : artists) {
		Artist artist = new Artist(artistName);
		artistService.saveArtist(artist);
	}
	
	
}
	

}
