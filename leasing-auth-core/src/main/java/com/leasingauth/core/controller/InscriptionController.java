package com.leasingauth.core.controller;

import com.leasingauth.core.domain.manage.ManageInscriptionService;
import com.leasingauth.util.dto.request.InscriptionRequest;
import com.leasingauth.util.dto.request.ScoreInscriptionRequest;
import com.leasingauth.util.dto.response.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/inscriptions")
@AllArgsConstructor
public class InscriptionController {

    private final ManageInscriptionService manageInscriptionService;

    @PostMapping
    public ResponseEntity<ResponseDto<String>> createInscription(@RequestBody @Valid InscriptionRequest inscriptionRequest) {
        this.manageInscriptionService.createInscription(inscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/score")
    public ResponseEntity<ResponseDto<String>> updateScoreInscription(@RequestBody @Valid ScoreInscriptionRequest scoreInscriptionRequest) {
        this.manageInscriptionService.updateScoreInscription(scoreInscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription score updated successfully"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<String>> updateInscription(@RequestBody @Valid InscriptionRequest inscriptionRequest) {
        this.manageInscriptionService.finishInscription(inscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription finished successfully"), HttpStatus.OK);
    }

}
