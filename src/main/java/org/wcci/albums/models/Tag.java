package org.wcci.albums.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany
	private List<Artist> artists;
	@ManyToMany
	private List<Album> albums;

	protected Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public void addArtist(Artist artist) {
		if (artists == null) {
			artists = new ArrayList<>();
		}
		artists.add(artist);
	}

	public void addAlbum(Album album) {
		if (albums == null) {
			albums = new ArrayList<>();
		}
		albums.add(album);
	}

}
