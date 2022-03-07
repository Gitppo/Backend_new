package HYLikeLion.gitppo.gitppoProject.domain.term;

import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@Schema(description = "약관 동의 여부")
public class TermAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TERM_AG_ID")
    private Long id;

    @OneToOne
    @NonNull
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @NonNull
    @JoinColumn(name = "TERM_ID")
    private Term term;

    @NonNull
    @Schema(description = "약관 동의일")
    private LocalDateTime agreeDate;

    @NonNull
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    @Schema(description = "약관 동의 여부", defaultValue = "1")
    private Boolean isAgree;

    @Builder
    public TermAgreement(@NonNull Term term, @NonNull LocalDateTime agreeDate,
        @NonNull Boolean isAgree, User user) {
        this.term = term;
        this.agreeDate = agreeDate;
        this.isAgree = isAgree;
        this.user = user;
    }
}
