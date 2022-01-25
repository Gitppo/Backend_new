package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResponseDTO {

	@NoArgsConstructor
	@Getter
	public static class ResponseObject {
		private StatusEnum status;
		private String message;
		private Object data;

		@Builder
		public ResponseObject(StatusEnum status, String message, Object data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponseList {
		private StatusEnum status;
		private String message;
		private List<Object> data;

		@Builder
		public ResponseList(StatusEnum status, String message, List<Object> data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponseId {
		private StatusEnum status;
		private String message;
		private Long id;

		@Builder
		public ResponseId(StatusEnum status, String message, Long id) {
			this.status = status;
			this.message = message;
			this.id = id;
		}
	}
}
