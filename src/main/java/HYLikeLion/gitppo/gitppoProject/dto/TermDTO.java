package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import HYLikeLion.gitppo.gitppoProject.domain.term.Term;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TermDTO {

    @NoArgsConstructor
    @Getter
    public static class Post {

        private Long termID;
        private Long userID;
        private Boolean termAgreementIsAgree;

        @Builder
        public Post(Long termID, Boolean termAgreementIsAgree, Long userID) {
            this.termID = termID;
            this.termAgreementIsAgree = termAgreementIsAgree;
            this.userID = userID;
        }
    }

    @NoArgsConstructor
    @Getter
    public static class GetResult {

        private String message;
        private List<Term> data;

        @Builder
        public GetResult(StatusEnum status, List<Term> data, String message) {
            this.data = data;
            this.message = message;
        }
    }

}

