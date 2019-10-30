package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.albums.controllers.ArtistController;
import org.wcci.albums.models.Artist;
import org.wcci.albums.services.ArtistService;

public class ArtistControllerTest {
	
	@InjectMocks
	ArtistController underTest;
	
	@Mock
	ArtistService artistService;
	@Mock
	TagRepository tagRepo;
	private MockMvc mockMvc;
	private Artist testArtist;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		testArtist = new Artist("Jessika");
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
	}
	
	@Test
	public void fetchAllReturnsListOfArtists () {
		when(artistService.findAllArtists()).thenReturn(Collections.singletonList(testArtist));
		List<Artist> retrievedArtists = underTest.fetchAll();
		assertThat(retrievedArtists, contains(testArtist));	
	}
	
	@Test
	public void shouldReturnAllArtists () throws Exception{
		when(artistService.findAllArtists()).thenReturn(Collections.singletonList(testArtist));
		mockMvc.perform(get("/api/artists"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		       .andExpect(jsonPath("$", hasSize(1)))
		       .andExpect(jsonPath("$[0].name", is(equalTo("Jessika"))));
	}
	
	@Ignore
	@Test
	public void shouldAddArtist() throws Exception {
		mockMvc.perform(post(".api/artists/add")
			   .contentType(MediaType.APPLICATION_JSON_UTF8)
			   .content("{" + "\"name\": \"Jessika\"" + "}"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}

	@Test
	public void addTagToArtist() throws Exception {
		when(artistService.findArtist(1L)).thenReturn(testArtist);
		Tag utTag = new Tag("Test Tag");
		underTest.addTag(1L, utTag);
		utTag.addArtist(testArtist);
		verify(tagRepo).save(utTag);
		verify(artistService, times(2)).findArtist(1L);
	}
}
