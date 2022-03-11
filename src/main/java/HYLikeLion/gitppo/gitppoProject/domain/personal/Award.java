package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Schema(description = "수상 실적")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AWARD_ID")
    private Long id;

    @NonNull
    @Schema(description = "이름")
    private String awName;

    @NonNull
    @Schema(description = "수상 내용")
    private String awContents;

    @NonNull
    @Schema(description = "수상일")
    private LocalDate awDate;

    @NonNull
    @Schema(description = "발급기관")
    private String awOrganization;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_ID")
    @Getter(AccessLevel.NONE)
    @Setter
    private Personal personal;

    public void update(@NonNull String awName, @NonNull String awContents,
        @NonNull LocalDate awDate, @NonNull String awOrganization) {
        this.awName = awName;
        this.awContents = awContents;
        this.awDate = awDate;
        this.awOrganization = awOrganization;
    }
}
