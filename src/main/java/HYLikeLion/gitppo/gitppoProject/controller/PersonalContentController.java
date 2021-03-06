package HYLikeLion.gitppo.gitppoProject.controller;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Skill;
import HYLikeLion.gitppo.gitppoProject.domain.personal.Sns;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO.ResponseId;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.personal.ActivityService;
import HYLikeLion.gitppo.gitppoProject.service.personal.AwardsService;
import HYLikeLion.gitppo.gitppoProject.service.personal.CareerService;
import HYLikeLion.gitppo.gitppoProject.service.personal.EducationService;
import HYLikeLion.gitppo.gitppoProject.service.personal.IntroductionService;
import HYLikeLion.gitppo.gitppoProject.service.personal.LicenseService;
import HYLikeLion.gitppo.gitppoProject.service.personal.PaperService;
import HYLikeLion.gitppo.gitppoProject.service.personal.SkillService;
import HYLikeLion.gitppo.gitppoProject.service.personal.SnsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonalContentController {

    private final ActivityService activityService;
    private final AwardsService awardsService;
    private final CareerService careerService;
    private final EducationService educationService;
    private final LicenseService licenseService;
    private final PaperService paperService;
    private final SkillService skillService;
    private final SnsService snsService;


    @Operation(summary = "?????? ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "?????? ?????? ??????"),
    })
    @DeleteMapping("personal/activity")
    public ResponseEntity<ResponseId> deleteActivity(
        @Parameter(description = "Activity id", required = true, example = "1") @RequestParam Long id) {
        activityService.deleteActivity(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("?????? ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "?????? ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "???????????? ?????? ??????"),
    })
    @DeleteMapping("personal/award")
    public ResponseEntity<ResponseId> deleteAward(
        @Parameter(description = "Award id", required = true, example = "1") @RequestParam Long id) {
        awardsService.deleteAward(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("???????????? ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "?????? ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "?????? ?????? ??????"),
    })
    @DeleteMapping("personal/career")
    public ResponseEntity<ResponseId> deleteCareer(
        @Parameter(description = "Career id", required = true, example = "1") @RequestParam Long id) {
        careerService.deleteCareer(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("?????? ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "education ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "education ?????? ??????"),
    })
    @DeleteMapping("personal/education")
    public ResponseEntity<ResponseId> deleteEducation(
        @Parameter(description = "Education id", required = true, example = "1") @RequestParam Long id) {
        educationService.deleteEducation(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("education ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "license ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "license ?????? ??????"),
    })
    @DeleteMapping("personal/license")
    public ResponseEntity<ResponseId> deleteLicense(
        @Parameter(description = "license id", required = true, example = "1") @RequestParam Long id) {
        licenseService.deleteLicense(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("license ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "paper ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "paper ?????? ??????"),
    })
    @DeleteMapping("personal/paper")
    public ResponseEntity<ResponseId> deletePaper(
        @Parameter(description = "paper id", required = true, example = "1") @RequestParam Long id) {
        paperService.deletePaper(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("paper ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "skill ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "skill ?????? ??????"),
    })
    @DeleteMapping("personal/skill")
    public ResponseEntity<ResponseId> deleteSkill(
        @Parameter(description = "skill id", required = true, example = "1") @RequestParam Long id) {
        skillService.deleteSkill(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("skill ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "sns ??????")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "sns ?????? ??????"),
    })
    @DeleteMapping("personal/sns")
    public ResponseEntity<ResponseId> deleteSns(
        @Parameter(description = "sns id", required = true, example = "1") @RequestParam Long id) {
        snsService.deleteSns(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("sns ?????? ??????")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }


}
