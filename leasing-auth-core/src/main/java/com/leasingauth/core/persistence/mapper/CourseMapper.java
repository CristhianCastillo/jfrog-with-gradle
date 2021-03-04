package com.leasingauth.core.persistence.mapper;

import com.leasingauth.core.persistence.entity.CourseEntity;
import com.leasingauth.util.dto.request.CourseRequest;
import com.leasingauth.util.dto.response.CourseResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseEntity convertRequestToEntity(CourseRequest courseRequest) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(courseRequest, CourseEntity.class);
    }

    public CourseResponse convertEntityToResponse(CourseEntity courseEntity) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(courseEntity, CourseResponse.class);
    }

}
