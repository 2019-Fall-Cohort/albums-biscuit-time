package org.wcci.albums.models;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageUrl;
	private String recordLabel;
	private String homeTown;
	@OneToMany(mappedBy = "artist")
	private List<Album> albums;
	@ElementCollection
	private List<Comment> comments;
	@ManyToMany(mappedBy = "artists")
	private List<Tag> tags;

	protected Artist() {
	}

	public Artist(String name, String imageUrl, String recordLabel, String homeTown) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.recordLabel = recordLabel;
		this.homeTown = homeTown;
		comments = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Artist other = (Artist) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void addAlbum(Album album) {
		albums.add(album);
		
	}

	

}
