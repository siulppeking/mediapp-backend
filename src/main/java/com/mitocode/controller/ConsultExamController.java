package com.mitocode.controller;

import com.mitocode.dto.ExamDTO;
import com.mitocode.model.ConsultExam;
import com.mitocode.model.Exam;
import com.mitocode.repo.IConsultExamRepo;
import com.mitocode.service.IConsultExamService;
import com.mitocode.service.IConsultService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/consultexams")
@RequiredArgsConstructor
public class ConsultExamController {

    private final IConsultExamService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping("/{idConsult}")
    public ResponseEntity<List<ExamDTO>> getExamsByConsultId(@PathVariable Integer idConsult) {
        List<ExamDTO> list = service.getExamsByConsultId(idConsult).stream().map(e -> modelMapper.map(e, ExamDTO.class)).toList();

        return ResponseEntity.ok(list);
    }
}
