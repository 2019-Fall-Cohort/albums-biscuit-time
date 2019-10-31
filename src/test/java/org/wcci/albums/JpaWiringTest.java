package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Comment;
import org.wcci.albums.models.Song;
import org.wcci.albums.models.Tag;
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.repositories.SongRepository;
import org.wcci.albums.repositories.TagRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private SongRepository songRepo;
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private TestEntityManager entityManager;

	Artist testArtist = new Artist("Ben");
	Album testAlbum = new Album("Greatest Hits", testArtist);
	Song testSong = new Song("Biscuit Time", testAlbum);

	@Test
	public void artistWillHaveAlbums() throws Exception {

		testArtist = artistRepo.save(testArtist);

		testAlbum = albumRepo.save(testAlbum);

		entityManager.flush();
		entityManager.clear();

		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();

		assertEquals(testArtist, retrievedArtist);
		assertThat(retrievedArtist.getAlbums(), contains(testAlbum));
	}

	@Test
	public void albumsWillHaveSongs() throws Exception {

		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		testSong = songRepo.save(testSong);

		entityManager.flush();
		entityManager.clear();

		Album retrievedAlbum = albumRepo.findById(testAlbum.getId()).get();

		assertEquals(testAlbum, retrievedAlbum);
		assertThat(retrievedAlbum.getSongs(), contains(testSong));

	}

	@Test
	public void artistsCanHaveComments() throws Exception {
		Artist testArtist = new Artist("Ben");
		Comment testComment = new Comment("This is an amazing comment!", "BOB");

		testArtist.addComment(testComment);
		testArtist = artistRepo.save(testArtist);

		entityManager.flush();
		entityManager.clear();

		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
		assertThat(retrievedArtist.getComments(), contains(testComment));
	}

	@Test
	public void albumsCanHaveComments() throws Exception {
		Artist testArtist = new Artist("Ben");
		Album testAlbum = new Album("Greatest Hits", testArtist);
		Comment testComment = new Comment("This is an amazing comment!", "BOB");

		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		testAlbum.addComment(testComment);

		entityManager.flush();
		entityManager.clear();

		Album retrievedAlbum = albumRepo.findById(testAlbum.getId()).get();
		assertThat(retrievedAlbum.getComments(), contains(testComment));
	}

	@Test
	public void songsCanHaveComments() throws Exception {
		Artist testArtist = new Artist("Ben");
		Album testAlbum = new Album("Greatest Hits", testArtist);
		Song testSong = new Song("Biscuit Time", testAlbum);
		Comment testComment = new Comment("This is an amazing comment!", "BOB");

		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		testSong = songRepo.save(testSong);
		testSong.addComment(testComment);

		entityManager.flush();
		entityManager.clear();

		Song retrievedSong = songRepo.findById(testSong.getId()).get();
		assertThat(retrievedSong.getComments(), contains(testComment));
	}
	
	@Test
	public void albumsAndArtistsAndSongsCanHaveTags() throws Exception {
		Artist testArtist = new Artist("Ben");
		Album testAlbum = new Album("Greatest Hits", testArtist);
		Song testSong = new Song("Biscuit Time", testAlbum);
		
		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		testSong = songRepo.save(testSong);
		
		Tag testTag = new Tag("fantastico");
		
		testTag = tagRepo.save(testTag);
		testTag.addAlbum(testAlbum);
		testTag.addArtist(testArtist);
		testTag.addSong(testSong);
		testTag = tagRepo.save(testTag);

		entityManager.flush();
		entityManager.clear();

		Tag retrievedTag = tagRepo.findById(testTag.getId()).get();
		Album retrievedAlbum = albumRepo.findById(testAlbum.getId()).get();
		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
		Song retrievedSong = songRepo.findById(testSong.getId()).get();
		
		assertThat(retrievedArtist.getTags(), contains(retrievedTag));
		assertThat(retrievedAlbum.getTags(), contains(retrievedTag));
		assertThat(retrievedSong.getTags(), contains(retrievedTag));
	}

}