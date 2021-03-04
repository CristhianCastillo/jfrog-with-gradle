package com.leasingauth.core.domain.manage;

import com.leasingauth.util.dto.request.InscriptionRequest;
import com.leasingauth.util.dto.request.ScoreInscriptionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ManageInscriptionService {

    void createInscription(InscriptionRequest inscriptionRequest);

    void updateScoreInscription(ScoreInscriptionRequest scoreInscriptionRequest);

    void finishInscription(InscriptionRequest inscriptionRequest);

}