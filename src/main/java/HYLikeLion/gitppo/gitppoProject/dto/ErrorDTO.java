package HYLikeLion.gitppo.gitppoProject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ErrorDTO {
	private StatusEnum status;
	private String message;

	@Builder
	public ErrorDTO(StatusEnum status, String message) {
		this.status = status;
		this.message = message;
	}
}
