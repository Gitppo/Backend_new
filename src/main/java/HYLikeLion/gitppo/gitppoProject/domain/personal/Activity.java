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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Schema(description = "활동")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTIVITY_ID")
    private Long id;

    @NonNull
    @Schema(description = "활동명")
    private String actName;

    @NonNull
    @Schema(description = "활동 내용")
    private String actContents;

    @NonNull
    @Schema(description = "활동 시작일")
    private LocalDate actStartDate;

    @Schema(description = "활동 종료일")
    private LocalDate actEndDate;

    @Schema(description = "활동 링크")
    private String actLink;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_ID")
    @Getter(AccessLevel.NONE)
    @Setter
    private Personal personal;

    public void update(String actName, String actContents, LocalDate actStartDate,
        LocalDate actEndDate, String actLink) {
        this.actName = actName;
        this.actContents = actContents;
        this.actStartDate = actStartDate;
        this.actEndDate = actEndDate;
        this.actLink = actLink;
    }
}
