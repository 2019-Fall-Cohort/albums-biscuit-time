package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import org.wcci.albums.models.Comment;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.services.ArtistService;

public class ArtistControllerTest {

	@InjectMocks
	ArtistController underTest;

	@Mock
	ArtistService artistService;
	@Mock
	private ArtistRepository artistRepo;
	@Mock
	private Artist mockArtist;
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
	public void fetchAllReturnsListOfArtists() {
		when(artistService.fetchAllArtists()).thenReturn(Collections.singletonList(testArtist));
		List<Artist> retrievedArtists = underTest.fetchAll();
		assertThat(retrievedArtists, contains(testArtist));
	}

	@Test
	public void shouldReturnAllArtists() throws Exception {
		when(artistService.fetchAllArtists()).thenReturn(Collections.singletonList(testArtist));
		mockMvc.perform(get("/api/artists")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(equalTo("Jessika"))));
	}

	@Test
	public void fetchByIdReturnsSingleArtist() {
		when(artistService.fetchArtist(1L)).thenReturn(testArtist);
		Artist retrievedArtist = underTest.fetchArtist(1L);
		assertThat(retrievedArtist, is(testArtist));
	}

	@Ignore
	public void fetchByArtistIsMappedCorrectlyandReturnsAJsonArtist() throws Exception {
		when(artistService.fetchArtist(1L)).thenReturn(testArtist);
		mockMvc.perform(get("api/artists/1"))
		       .andDo(print())
		       .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(jsonPath("$.name", is(equalTo("Luke"))));

	}

	@Test
	public void addCommentsAddsArtistComment() {
		when(artistService.fetchArtist(1L)).thenReturn(testArtist);
		when(artistService.saveArtist(testArtist)).thenReturn(testArtist);
		Comment testComment = new Comment("Testing", "test");
		Artist commentOnArtist = underTest.addComment(1L, testComment);
		assertThat(commentOnArtist.getComments(), contains(testComment));
	}

	@Ignore
	public void addCommentToArtistMappingWorks() throws Exception {
		when(artistService.fetchArtist(1L)).thenReturn(testArtist);
		when(artistService.saveArtist(testArtist)).thenReturn(testArtist);

	}

	@Test
	public void addTagToArtist() throws Exception {
		when(artistService.fetchArtist(1L)).thenReturn(testArtist);
		Tag utTag = new Tag("Test Tag");
		underTest.addTag(1L, utTag);
		utTag.addArtist(testArtist);
		verify(tagRepo).save(utTag);
		verify(artistService, times(2)).fetchArtist(1L);
	}
	
	
}
