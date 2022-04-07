package HYLikeLion.gitppo.gitppoProject.service.personal;

import HYLikeLion.gitppo.gitppoProject.domain.personal.License;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.repository.Personal.LicenseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    @Transactional
    public void saveLicense(List<License> licenses, Personal personal) {
        for (License license : licenses) {
            license.setPersonal(personal);
            licenseRepository.save(license);
        }
    }

    @Transactional
    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }
}
