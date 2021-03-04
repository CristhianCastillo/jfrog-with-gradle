package com.leasingauth.core.controller;

import com.leasingauth.core.domain.manage.ManageCourseService;
import com.leasingauth.util.dto.request.CourseRequest;
import com.leasingauth.util.dto.response.CourseResponse;
import com.leasingauth.util.dto.response.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@AllArgsConstructor
public class CourseController {

    private final ManageCourseService manageCourseService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<CourseResponse>>> getAllCourses() {
        return new ResponseEntity<>(ResponseDto.success(this.manageCourseService.getAllCourses()), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ResponseDto<CourseResponse>> getCourseById(@PathVariable Long courseId) {
        return new ResponseEntity<>(ResponseDto.success(this.manageCourseService.getCourseById(courseId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<CourseResponse>> createCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageCourseService.createCourse(courseRequest)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<CourseResponse>> updateCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return new ResponseEntity<>(ResponseDto.success(this.manageCourseService.updateCourse(courseRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ResponseDto<String>> deleteCourse(@PathVariable Long courseId) {
        this.manageCourseService.deleteCourse(courseId);
        return new ResponseEntity<>(ResponseDto.success("Successfully removed"), HttpStatus.OK);
    }

}
