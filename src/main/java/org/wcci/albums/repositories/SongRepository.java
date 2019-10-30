package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.albums.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
