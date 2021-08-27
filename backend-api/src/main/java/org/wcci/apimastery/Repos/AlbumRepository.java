package org.wcci.apimastery.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.pojos.Album;


public interface AlbumRepository extends CrudRepository<Album, Long> {
}