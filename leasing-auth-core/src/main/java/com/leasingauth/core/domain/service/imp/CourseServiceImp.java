package com.leasingauth.core.domain.service.imp;

import com.leasingauth.core.constant.StatusConstant;
import com.leasingauth.core.domain.service.CourseService;
import com.leasingauth.core.persistence.crud.CourseRepository;
import com.leasingauth.core.persistence.entity.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseEntity> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public CourseEntity getById(Long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course with id: " + id + " not found."));
    }

    @Override
    public CourseEntity save(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity update(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

    @Override
    public void delete(CourseEntity courseEntity) {
        courseEntity.setStatus(StatusConstant.DISABLED_STATUS);
        this.courseRepository.save(courseEntity);
    }
}
