package HYLikeLion.gitppo.gitppoProject.dto;

import HYLikeLion.gitppo.gitppoProject.domain.skillList.SkillContent;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SkillListDTO {

    @NoArgsConstructor
    @Getter
    public static class ResponseList{
        private StatusEnum status;
        private String message;
        private List<SkillContent> data;

        @Builder
        public ResponseList(StatusEnum status, String message, List<SkillContent> data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }
    }
}
