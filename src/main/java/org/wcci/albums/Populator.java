package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Song;
import org.wcci.albums.models.Tag;
//import org.wcci.albums.repositories.AlbumRepository;
//import org.wcci.albums.repositories.ArtistRepository;
//import org.wcci.albums.repositories.SongRepository;
//import org.wcci.albums.repositories.TagRepository;
import org.wcci.albums.services.AlbumService;
import org.wcci.albums.services.ArtistService;
import org.wcci.albums.services.SongService;
import org.wcci.albums.services.TagService;

@Component
public class Populator implements CommandLineRunner{
	
//	@Autowired
//	private ArtistRepository artistRepo;
//	@Autowired
//	private AlbumRepository albumRepo;
//	@Autowired
//	private SongRepository songRepo;
//	@Autowired
//	private TagRepository tagRepo;
	
	@Autowired
	private ArtistService artistService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private SongService songService;
	@Autowired
	private TagService tagService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Instantiate 8 Artists
		Artist artist1 = new Artist("David Bowie", "https://cdn2.lamag.com/wp-content/uploads/sites/6/2016/01/bowie.jpg", "Parlophone", "Bromley, Kent,UK");
		Artist artist2 = new Artist("Cat Stevens", "https://www.rollingstone.com/wp-content/uploads/2018/06/rs-27915-catstevens-1800-1386942005.jpg", "A&M", "London, UK");
		Artist artist3 = new Artist("Judy Collins", "https://www.mcall.com/resizer/W5ekIoDwL2zLDf-fBlF9wADvFfs=/800x449/top/arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/4OKB7APLQJBG7EWZ7S2M2IBUCU.jpg", "Wildflower", "Denver, CO");
		Artist artist4 = new Artist("Elton John", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Elton_John_Cannes_2019.jpg/375px-Elton_John_Cannes_2019.jpg", "Rocket", "Pinner, UK");
		Artist artist5 = new Artist("Bob Dylan", "https://miro.medium.com/max/7860/1*_EDEWvWLREzlAvaQRfC_SQ.jpeg", "Columbia", "Hibbing, MN");
		Artist artist6 = new Artist("Mumford & Sons", "https://www.billboard.com/files/styles/landscape_768/public/media/Mumford-and-Sons-press-by-Gavin-Batty-2019-billboard-1548.jpg", "Glassnote", "London, UK");
		Artist artist7 = new Artist("CS&N", "https://images-na.ssl-images-amazon.com/images/I/811-vOtyMHL._SX522_.jpg", "Atlantic", "Los Angeles, CA");
		Artist artist8 = new Artist("Chris Stapleton", "https://www.billboard.com/files/styles/landscape_768/public/media/chris-stapleton-smiling-MSG-2015-billboard-650.jpg", "Mercury Nashville", "Staffordsville, KY");

		//Save all 8 Artists
		artistService.saveArtist(artist1);
		artistService.saveArtist(artist2);
		artistService.saveArtist(artist3);
		artistService.saveArtist(artist4);
		artistService.saveArtist(artist5);
		artistService.saveArtist(artist6);
		artistService.saveArtist(artist7);
		artistService.saveArtist(artist8);
		
//		artistRepo.save(artist1);

		//Instantiate 16 Albums
		//David Bowie
		Album album1_1 = new Album("Diamond Dogs", artist1);
		Album album1_2 = new Album("Ziggy Stardust", artist1);
		//Cat Stevens
		Album album2_1 = new Album("Tea for the Tillerman", artist2);
		Album album2_2 = new Album("Catch Bull at Four", artist2);
		//Judy Collins
		Album album3_1 = new Album("Wildflowers", artist3);
		Album album3_2 = new Album("Who Knows Where the Time Goes", artist3);
		//Elton John
		Album album4_1 = new Album("Elton John", artist4);
		Album album4_2 = new Album("Made in England", artist4);
		//Bob Dylan
		Album album5_1 = new Album("Blonde on Blonde", artist5);
		Album album5_2 = new Album("Blood on the Tracks", artist5);
		//Mumford & Sons
		Album album6_1 = new Album("Sigh No More", artist6);
		Album album6_2 = new Album("Wilder Mind", artist6);
		//CS&N
		Album album7_1 = new Album("Crosby, Stills & Nash", artist7);
		Album album7_2 = new Album("Daylight Again", artist7);
		//Chris Stapleton
		Album album8_1 = new Album("Traveller", artist8);
		Album album8_2 = new Album("From a Room: Volume 1", artist8);
		
		//Save all 16 Albums
		albumService.saveAlbum(album1_1);
		albumService.saveAlbum(album1_2);
		albumService.saveAlbum(album2_1);
		albumService.saveAlbum(album2_2);
		albumService.saveAlbum(album3_1);
		albumService.saveAlbum(album3_2);
		albumService.saveAlbum(album4_1);
		albumService.saveAlbum(album4_2);
		albumService.saveAlbum(album5_1);
		albumService.saveAlbum(album5_2);
		albumService.saveAlbum(album6_1);
		albumService.saveAlbum(album6_2);
		albumService.saveAlbum(album7_1);
		albumService.saveAlbum(album7_2);
		albumService.saveAlbum(album8_1);
		albumService.saveAlbum(album8_2);
		
//		albumRepo.save(album);
		
		//Instantiate 32 Songs
		//David Bowie
		Song song1_1_1 = new Song("Rebel Rebel", album1_1);
		Song song1_1_2 = new Song("Diamond Dogs", album1_1);
		Song song1_2_1 = new Song("Moonage Daydream", album1_2);
		Song song1_2_2 = new Song("Five Years", album1_2);
		//Cat Stevens
		Song song2_1_1 = new Song("Father and Son", album2_1);
		Song song2_1_2 = new Song("Hard Headed Woman", album2_1);
		Song song2_2_1 = new Song("Sitting", album2_2);
		Song song2_2_2 = new Song("Sweet Scarlet", album2_2);
		//Judy Collins
		Song song3_1_1 = new Song("Since You've Asked", album3_1);
		Song song3_1_2 = new Song("Michael from Mountains", album3_1);
		Song song3_2_1 = new Song("My Father", album3_2);
		Song song3_2_2 = new Song("Someday Soon", album3_2);
		//Elton John
		Song song4_1_1 = new Song("Your Song", album4_1);
		Song song4_1_2 = new Song("Take Me to the Pilot", album4_1);
		Song song4_2_1 = new Song("Believe", album4_2);
		Song song4_2_2 = new Song("Man", album4_2);
		//Bob Dylan
		Song song5_1_1 = new Song("Visions of Johanna", album5_1);
		Song song5_1_2 = new Song("Just Like a Woman", album5_1);
		Song song5_2_1 = new Song("Tangled Up in Blue", album5_2);
		Song song5_2_2 = new Song("Shelter from the Storm", album5_2);
		//Mumford & Sons
		Song song6_1_1 = new Song("The Cave", album6_1);
		Song song6_1_2 = new Song("Little Lion Man", album6_1);
		Song song6_2_1 = new Song("Cold Arms", album6_2);
		Song song6_2_2 = new Song("Ditmas", album6_2);
		//CS&N
		Song song7_1_1 = new Song("Helplessly Hoping", album7_1);
		Song song7_1_2 = new Song("Suite: Judy Blue Eyes", album7_1);
		Song song7_2_1 = new Song("Southern Cross", album7_2);
		Song song7_2_2 = new Song("Wasted on the Way", album7_2);
		//Chris Stapleton
		Song song8_1_1 = new Song("Traveller", album8_1);
		Song song8_1_2 = new Song("Nobody to Blame", album8_1);
		Song song8_2_1 = new Song("Either Way", album8_2);
		Song song8_2_2 = new Song("Broken Halos", album8_2);
		
		//Save all 32 Songs
		songService.saveSong(song1_1_1);
		songService.saveSong(song1_1_2);
		songService.saveSong(song1_2_1);
		songService.saveSong(song1_2_2);
		songService.saveSong(song2_1_1);
		songService.saveSong(song2_1_2);
		songService.saveSong(song2_2_1);
		songService.saveSong(song2_2_2);
		songService.saveSong(song3_1_1);
		songService.saveSong(song3_1_2);
		songService.saveSong(song3_2_1);
		songService.saveSong(song3_2_2);
		songService.saveSong(song4_1_1);
		songService.saveSong(song4_1_2);
		songService.saveSong(song4_2_1);
		songService.saveSong(song4_2_2);
		songService.saveSong(song5_1_1);
		songService.saveSong(song5_1_2);
		songService.saveSong(song5_2_1);
		songService.saveSong(song5_2_2);
		songService.saveSong(song6_1_1);
		songService.saveSong(song6_1_2);
		songService.saveSong(song6_2_1);
		songService.saveSong(song6_2_2);
		songService.saveSong(song7_1_1);
		songService.saveSong(song7_1_2);
		songService.saveSong(song7_2_1);
		songService.saveSong(song7_2_2);
		songService.saveSong(song8_1_1);
		songService.saveSong(song8_1_2);
		songService.saveSong(song8_2_1);
		songService.saveSong(song8_2_2);
		
//		songRepo.save(song);
//		songRepo.save(song2);
		
		Tag tag = new Tag("Glam");
		Tag tag2 = new Tag("Funky");
		
//		tagRepo.save(tag);
//		tagRepo.save(tag2);
		
	}

}
