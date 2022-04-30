package HYLikeLion.gitppo.gitppoProject.domain.personal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import HYLikeLion.gitppo.gitppoProject.domain.image.Image;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONAL_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "PF_ID")
    @Getter(AccessLevel.PACKAGE)
    private Portfolio portfolio;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "INTRO_ID")
    private Introduction introduction;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "BASICINFO_ID")
    private BasicInfo basicInfo;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Career> careers;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<License> licenses;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Activity> activities;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Award> awards;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Sns> snsList;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(mappedBy = "personal", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Paper> papers;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "IMG_ID")
    private Image image;

    @Builder
    public Personal(Portfolio portfolio, Introduction introduction, BasicInfo basicInfo, List<Career> careers, List<Education> educations, List<License> licenses, List<Activity> activities, List<Award> awards, List<Sns> snsList, List<Skill> skills, List<Paper> papers, Image image) {
        this.portfolio = portfolio;
        this.introduction = introduction;
        this.basicInfo = basicInfo;
        this.careers = careers;
        this.educations = educations;
        this.licenses = licenses;
        this.activities = activities;
        this.awards = awards;
        this.snsList = snsList;
        this.skills = skills;
        this.papers = papers;
        this.image = image;
    }

    public void update(Introduction introduction,
        BasicInfo basicInfo,
        List<Career> careers,
        List<Education> educations,
        List<License> licenses,
        List<Activity> activities,
        List<Award> awards, List<Sns> snsList,
        List<Skill> skills,
        List<Paper> papers,
        Image image) {
        this.introduction = introduction;
        this.basicInfo = basicInfo;
        this.careers = careers;
        this.educations = educations;
        this.licenses = licenses;
        this.activities = activities;
        this.awards = awards;
        this.snsList = snsList;
        this.skills = skills;
        this.papers = papers;
        this.image = image;
    }
}
