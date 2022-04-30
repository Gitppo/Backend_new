package HYLikeLion.gitppo.gitppoProject.domain.image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import HYLikeLion.gitppo.gitppoProject.domain.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Schema(description = "이미지 파일 정보")
public class Image extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMG_ID")
	private Long id;

	@Column(nullable = false)
	@Schema(description = "이미지 파일 이름")
	private String imgName;

	@Column(nullable = false, length = 1000)
	@Schema(description = "이미지 파일 저장 경로")
	private String imgUrl;

	@Builder
	public Image(String imgName, String imgUrl) {
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
}
