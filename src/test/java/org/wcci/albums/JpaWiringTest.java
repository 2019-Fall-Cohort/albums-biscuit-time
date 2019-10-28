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
	private TestEntityManager entityManager;
	
//	@Before
//	public setup() {
//		Artist testArtist = new Artist("Ben");
//	}

	@Test
	public void artistWillHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Ben");
		
		Album testAlbum1 = new Album("Greatest Hits", testArtist);
		
		testArtist = artistRepo.save(testArtist);
		
		testAlbum1 = albumRepo.save(testAlbum1);
		
		entityManager.flush();
		entityManager.clear();
		
		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
		
		assertEquals(testArtist, retrievedArtist);
		assertThat(retrievedArtist.getAlbums(), contains(testAlbum1));
	}
	
	@Test
	public void songsWillHaveArtist() throws Exception {
		Song testSong = new Song("Biscuit Time");
		
		Artist testArtist = new Artist("Ben");
		
		testSong = songRepo.save(testSong);
		
		testArtist = artistRepo.save(testArtist);
		
		entityManager.flush();
		entityManager.clear();
		
		Song retrievedSong = songRepo.findById(testSong.getId()).get();
		
		assertEquals(testSong, retrievedSong);
	}
}