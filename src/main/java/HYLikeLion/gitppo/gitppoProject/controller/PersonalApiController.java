package HYLikeLion.gitppo.gitppoProject.controller;

import HYLikeLion.gitppo.gitppoProject.domain.personal.Personal;
import HYLikeLion.gitppo.gitppoProject.dto.PersonalDTO;
import HYLikeLion.gitppo.gitppoProject.dto.ResponseDTO;
import HYLikeLion.gitppo.gitppoProject.dto.StatusEnum;
import HYLikeLion.gitppo.gitppoProject.service.PersonalService;
import HYLikeLion.gitppo.gitppoProject.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class PersonalApiController {

    private final PersonalService personalService;
    private final PortfolioService portfolioService;

    @Operation(summary = "개인정보 조회")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "개인 정보 조회 완료", content = @Content(schema = @Schema(implementation = Personal.class))),
    })
    @GetMapping("personal")
    public ResponseEntity<ResponseDTO.ResponseObject> getPortfolio(
        @Parameter(description = "Personal id", example = "1") @RequestParam Long id) throws
        NotFoundException {
        Personal personal = personalService.getPersonal(id);
        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseObject dto = ResponseDTO.ResponseObject.builder()
            .status(StatusEnum.OK)
            .data(personal)
            .message("개인 정보 조회 완료")
            .build();

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
    }

    @Operation(summary = "개인정보 저장")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "개인 정보 저장 완료", content = @Content(schema = @Schema(implementation = Personal.class))),
    })
    @PostMapping("personal")
    public ResponseEntity<ResponseDTO.ResponseObject> postPortfolio(
        @RequestBody PersonalDTO.AddPersonal dto) {
        Personal personal = personalService.savePersonal(dto);
        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseObject response = ResponseDTO.ResponseObject.builder()
            .status(StatusEnum.OK)
            .data(personal)
            .message("개인 정보 저장 완료")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "개인정보 삭제")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "개인 정보 삭제 완료"),
    })
    @DeleteMapping("personal")
    public ResponseEntity<ResponseDTO.ResponseId> deletePortfolio(
        @Parameter(description = "Personal id", required = true, example = "1") @RequestParam Long id) {
        personalService.deletePersonal(id);

        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseId response = ResponseDTO.ResponseId.builder()
            .status(StatusEnum.OK)
            .id(id)
            .message("개인 정보 삭제 완료")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }

    @Operation(summary = "개인정보 수정")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "개인 정보 수정 완료", content = @Content(schema = @Schema(implementation = Personal.class))),
    })
    @PutMapping("personal")
    public ResponseEntity<ResponseDTO.ResponseObject> editPersonal(
        @RequestBody PersonalDTO.EditPersonal dto) throws NotFoundException {
        Personal personal = personalService.editPersonal(dto);
        HttpHeaders header = new HttpHeaders();

        ResponseDTO.ResponseObject response = ResponseDTO.ResponseObject.builder()
            .status(StatusEnum.OK)
            .data(personal)
            .message("개인 정보 저장 완료")
            .build();

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }
}
