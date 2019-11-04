package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.wcci.albums.exceptions.AlbumNotFoundException;
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.services.AlbumService;


public class AlbumServiceTest {
	
	@InjectMocks
	AlbumService underTest;
	@Mock
	private AlbumRepository albumRepo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void shouldThrowNotFoundExceptionWhenAlbumDoesntExist() {
    	 when(albumRepo.findById(1L)).thenReturn(Optional.empty());
    	 try {
    		 underTest.fetchAlbum(1L);
    		 fail("Exception not thrown");
    	 }catch (AlbumNotFoundException e) {
    		 assertThat(e.getMessage(), is(equalTo("Album not found.")));
    	 }
    }

}


