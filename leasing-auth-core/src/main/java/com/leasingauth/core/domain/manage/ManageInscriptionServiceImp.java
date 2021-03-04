package com.leasingauth.core.domain.manage;

import com.leasingauth.core.constant.StatusConstant;
import com.leasingauth.core.domain.service.CourseService;
import com.leasingauth.core.domain.service.InscriptionService;
import com.leasingauth.core.domain.service.UserService;
import com.leasingauth.core.persistence.entity.CourseEntity;
import com.leasingauth.core.persistence.entity.InscriptionEntity;
import com.leasingauth.core.persistence.entity.UserEntity;
import com.leasingauth.core.persistence.entity.id.InscriptionId;
import com.leasingauth.util.dto.request.InscriptionRequest;
import com.leasingauth.util.dto.request.ScoreInscriptionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManageInscriptionServiceImp implements ManageInscriptionService {

    private final UserService userService;
    private final CourseService courseService;
    private final InscriptionService inscriptionService;

    @Override
    public void createInscription(InscriptionRequest inscriptionRequest) {
        // 1. Validate user exists
        // 2. Validate course exists
        // 3. Validate that inscription not exists
        // 4. Create Inscription
        UserEntity user = this.userService.getById(inscriptionRequest.getUserId());
        CourseEntity course = this.courseService.getById(inscriptionRequest.getCourseId());
        InscriptionEntity inscription = this.inscriptionService.getByUserIdAndCourseId(inscriptionRequest.getUserId(), inscriptionRequest.getCourseId());
        if (inscription != null) {
            throw new RuntimeException("Inscription Already Exists!");
        }
        inscription = new InscriptionEntity();
        InscriptionId inscriptionId = new InscriptionId(user, course);
        inscription.setInscriptionId(inscriptionId);
        inscription.setScore(0L);
        inscription.setStatus(StatusConstant.ENABLED_STATUS);
        this.inscriptionService.save(inscription);
    }

    @Override
    public void updateScoreInscription(ScoreInscriptionRequest scoreInscriptionRequest) {
        // 1. Validate that inscription exists.
        // 2. Validate that inscription is enable.
        // 3. Set score
        // 4. Update Inscription score
        InscriptionEntity inscription = this.inscriptionService.getByUserIdAndCourseId(scoreInscriptionRequest.getUserId(), scoreInscriptionRequest.getCourseId());
        if (!inscription.getStatus().equals(StatusConstant.ENABLED_STATUS)) {
            throw new RuntimeException("Inscription is not Enabled!");
        }
        inscription.setScore(scoreInscriptionRequest.getScore());
        this.inscriptionService.update(inscription);
    }

    @Override
    public void finishInscription(InscriptionRequest inscriptionRequest) {
        // 1. Validate that inscription exists.
        // 2. Validate that inscription is enable.
        // 3. Validate that score is 3 or more.
        // 4. Update Inscription status and save.
        InscriptionEntity inscription = this.inscriptionService.getByUserIdAndCourseId(inscriptionRequest.getUserId(), inscriptionRequest.getCourseId());
        if (!inscription.getStatus().equals(StatusConstant.ENABLED_STATUS)) {
            throw new RuntimeException("Inscription is not Enabled!");
        }
        if (inscription.getScore() < 3L) {
            throw new RuntimeException("The score is not valid to finish");
        }
        inscription.setStatus(StatusConstant.FINALIZED_STATUS);
        this.inscriptionService.update(inscription);
    }
}
