package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ResponseDTO{

	@NoArgsConstructor
	@Getter
	public static class ResponseObject <T>{
		private StatusEnum status;
		private String message;
		private T data;

		@Builder
		public ResponseObject(StatusEnum status, String message, T data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}

	@NoArgsConstructor
	@Getter
	public static class ResponseList <T>{
		private StatusEnum status;
		private String message;
		private List<T> data;

		@Builder
		public ResponseList(StatusEnum status, String message, List<T> data) {
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
