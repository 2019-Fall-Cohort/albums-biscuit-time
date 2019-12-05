package org.wcci.albums.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlbumNotFoundException extends RuntimeException {

	public AlbumNotFoundException(String message) {
			super(message);
	}
}
