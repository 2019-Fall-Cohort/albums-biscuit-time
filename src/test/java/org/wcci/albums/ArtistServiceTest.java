package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.albums.exceptions.ArtistNotFoundException;
import org.wcci.albums.models.Artist;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.services.ArtistService;

public class ArtistServiceTest {
	
	@InjectMocks
	ArtistService underTest;
	@Mock
	private ArtistRepository artistRepo;
	@Mock
	private Artist mockArtist;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void shouldThrowNotFoundExceptionWhenArtistDoesntExist() {
    	 when(artistRepo.findById(1L)).thenReturn(Optional.empty());
    	 try {
    		 underTest.fetchArtist(1L);
    		 fail("Exception not thrown");
    	 }catch (ArtistNotFoundException e) {
    		 assertThat(e.getMessage(), is(equalTo("Artist not found.")));
    	 }
    }
	
	@Test
	public void shouldAddArtistToRepo() throws Exception {
		Artist storedArtist = underTest.saveArtist(mockArtist);
		verify(artistRepo).save(mockArtist);
	}

	@Test
	public void shouldDeleteArtistFromRepo() throws Exception {
		underTest.deleteArtist(mockArtist);
		verify(artistRepo).delete(mockArtist);
	}
	
}
