package org.wcci.apimastery.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.pojos.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
}
