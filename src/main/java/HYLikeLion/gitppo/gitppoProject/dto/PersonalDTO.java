package HYLikeLion.gitppo.gitppoProject.dto;

import java.util.List;

import HYLikeLion.gitppo.gitppoProject.domain.personal.*;
import HYLikeLion.gitppo.gitppoProject.domain.portfolio.Portfolio;
import HYLikeLion.gitppo.gitppoProject.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PersonalDTO {

    @NoArgsConstructor
    @Data
    public static class AddPersonal {

        private Long pfId;
        private Introduction introduction;
        private BasicInfo basicInfo;

        private List<Career> careers;
        private List<Education> educations;
        private List<License> licenses;
        private List<Activity> activities;
        private List<Award> awards;
        private List<Sns> snsList;
        private List<Skill> skills;
        private List<Paper> papers;

        public Personal toEntity(Portfolio portfolio) {
            return Personal.builder()
                .introduction(introduction)
                .basicInfo(basicInfo)
                .careers(careers)
                .educations(educations)
                .licenses(licenses)
                .activities(activities)
                .awards(awards)
                .snsList(snsList)
                .skills(skills)
                .papers(papers)
                .portfolio(portfolio)
                .build();
        }
    }

    @NoArgsConstructor
    @Data
    public static class EditPersonal {

        private Long id;
        private Long pfId;
        private Introduction introduction;
        private BasicInfo basicInfo;

        private List<Career> careers;
        private List<Education> educations;
        private List<License> licenses;
        private List<Activity> activities;
        private List<Award> awards;
        private List<Sns> snsList;
        private List<Skill> skills;
        private List<Paper> papers;

        public Personal toEntity(Portfolio portfolio) {
            return Personal.builder()
                .id(id)
                .portfolio(portfolio)
                .introduction(introduction)
                .basicInfo(basicInfo)
                .careers(careers)
                .educations(educations)
                .licenses(licenses)
                .activities(activities)
                .awards(awards)
                .snsList(snsList)
                .skills(skills)
                .papers(papers)
                .build();
        }
    }
}
