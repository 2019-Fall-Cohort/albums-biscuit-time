package org.wcci.albums.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.exceptions.TagNotFoundException;
import org.wcci.albums.models.Tag;
import org.wcci.albums.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepo;

	public Tag saveTag(Tag tag) {
		return tagRepo.save(tag);
	}

	public Tag fetchTag(Long id) {
		Optional<Tag> retrievedTagOptional = tagRepo.findById(id);
		if (!retrievedTagOptional.isPresent()) {
			throw new TagNotFoundException("Tag not found.");
		}
		return retrievedTagOptional.get();
	}
	
	public List<Tag> fetchAllTags() {
		return (List<Tag>) tagRepo.findAll();
	}
	
}
