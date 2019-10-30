package org.wcci.albums;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.wcci.albums.models.Artist;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany
	private List<Artist> artists;
	
	protected Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}

	public void addArtist(Artist artistToAdd) {
		if(artists == null) {
			artists = new ArrayList<>();
		}
		artists.add(artistToAdd);
	}

}
