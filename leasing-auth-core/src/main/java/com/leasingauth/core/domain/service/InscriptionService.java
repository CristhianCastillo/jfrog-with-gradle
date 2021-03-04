package com.leasingauth.core.domain.service;

import com.leasingauth.core.persistence.entity.InscriptionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscriptionService {

    List<InscriptionEntity> getByUserId(Long userId);

    InscriptionEntity getByUserIdAndCourseId(Long userId, Long courseId);

    InscriptionEntity save(InscriptionEntity inscriptionEntity);

    InscriptionEntity update(InscriptionEntity inscriptionEntity);

    void delete(InscriptionEntity inscriptionEntity);

}
