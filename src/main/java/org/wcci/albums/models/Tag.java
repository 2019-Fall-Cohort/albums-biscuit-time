package org.wcci.albums.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@JsonIgnore
	@ManyToMany
	private List<Artist> artists;
	@JsonIgnore
	@ManyToMany
	private List<Album> albums;
	@JsonIgnore
	@ManyToMany
	private List<Song> songs;

	protected Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
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

	public void addSong(Song song) {
		if (songs == null) {
			songs = new ArrayList<>();
		}
		songs.add(song);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
		result = prime * result + ((artists == null) ? 0 : artists.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		if (artists == null) {
			if (other.artists != null)
				return false;
		} else if (!artists.equals(other.artists))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", artists=" + artists + ", albums=" + albums + ", songs=" + songs
				+ "]";
	}

	

}
