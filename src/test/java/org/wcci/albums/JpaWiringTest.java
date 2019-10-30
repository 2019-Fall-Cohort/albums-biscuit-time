package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;


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
	
}