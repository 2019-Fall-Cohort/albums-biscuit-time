package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.albums.controllers.SongController;
import org.wcci.albums.models.Album;
import org.wcci.albums.models.Artist;
import org.wcci.albums.models.Comment;
import org.wcci.albums.models.Song;
import org.wcci.albums.services.SongService;

public class SongControllerTest {
	@InjectMocks
	private SongController underTest;

	@Mock
	private SongService songService;

	private MockMvc mockMvc;
	
	private Song testSong;

	private Album testAlbum;
	

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		testAlbum = new Album("testAlbum", new Artist("Jane"));
		testSong = new Song("testSong", testAlbum);
	}
	
	@Test
	public void fetchAllReturnsListOfSongs() throws Exception {
		when(songService.fetchAllSongs()).thenReturn(Collections.singletonList(testSong));
		List<Song> retrievedSongs = underTest.fetchAll();
		assertThat(retrievedSongs, contains(testSong));
	}
	
	@Test
	public void fetchAllIsMappedCorrectlyAndReturnsAJsonList() throws Exception {
		when(songService.fetchAllSongs()).thenReturn(Collections.singletonList(testSong));
		mockMvc.perform(get("/api/songs"))
		       .andDo(print())
		       .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
			   .andExpect(jsonPath("$[0].name", is(equalTo("testSong"))));
	}
	
	@Test
	public void fetchByIdReturnsSingleSong() {
		when(songService.fetchSong(1L)).thenReturn(testSong);
		Song retrievedSong = underTest.fetchById(1L);
		assertThat(retrievedSong, is(testSong));
	}
	
	@Test
	public void fetchByIdIsMappedCorrectlyAndReturnsAJsonSong() throws Exception {
		when(songService.fetchSong(1L)).thenReturn(testSong);
		mockMvc.perform(get("/api/songs/1"))
			   .andDo(print())
		       .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(jsonPath("$.name", is(equalTo("testSong"))));
	}
	
	@Test
    public void addCommentAddsCommentsToSelectedSong() {
        when(songService.fetchSong(1L)).thenReturn(testSong);
        when(songService.saveSong(testSong)).thenReturn(testSong);
        Comment testComment = new Comment("TESTING", "TESTY");
        Song commentedOnSong = underTest.addComment(1L, testComment);
        assertThat(commentedOnSong.getComments(), contains(testComment));
    }
	
	
}
