package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Activity;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.ActivityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Transactional
    public void setActivities(List<Activity> activities, Personal personal) {
        for (Activity activity : activities) {
            activity.setPersonal(personal);
            activityRepository.save(activity);
        }
    }
    @Transactional
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

}
