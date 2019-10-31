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
import org.wcci.albums.repositories.SongRepository;
import org.wcci.albums.services.SongService;

public class SongServiceTest {

	@InjectMocks
	SongService underTest;
	@Mock
	private SongRepository songRepo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void shouldThrowNotFoundExceptionWhenSongDoesntExist() {
    	 when(songRepo.findById(1L)).thenReturn(Optional.empty());
    	 try {
    		 underTest.fetchSong(1L);
    		 fail("Exception not thrown");
    	 }catch (SongNotFoundException e) {
    		 assertThat(e.getMessage(), is(equalTo("Song not found.")));
    	 }
    }

}

