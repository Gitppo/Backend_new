package HYLikeLion.gitppo.gitppoProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import HYLikeLion.gitppo.gitppoProject.dto.ErrorDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import javassist.NotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDTO> notFoundException(NotFoundException e) {
		ErrorDTO er = ErrorDTO.builder()
			.status(StatusEnum.NOT_FOUND)
			.message(e.getMessage())
			.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDTO> illegalArgumentException(IllegalArgumentException e) {
		ErrorDTO er = ErrorDTO.builder()
			.status(StatusEnum.BAD_REQUEST)
			.message(e.getMessage())
			.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
}
