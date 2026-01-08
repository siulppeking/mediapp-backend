package com.mitocode.controller;

import com.mitocode.dto.PatientDTO;
import com.mitocode.model.Patient;
import com.mitocode.service.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/patients")
//@CrossOrigin(origins = "http://localhost:4200") //Angular
//@RequestMapping("${patients.url}") //EL Expression Language
public class PatientController {

    //@Autowired
    private final IPatientService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() throws Exception {
        //ModelMapper modelMapper = new ModelMapper();
        //List<PatientDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, PatientDTO.class)).toList();
        List<PatientDTO> list = service.findAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Integer id) throws Exception {
        Patient obj = service.findById(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PatientDTO dto) throws Exception {
        Patient obj = service.save(modelMapper.map(dto, Patient.class));

        // localhost:8080/v1/patients/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@Valid @PathVariable Integer id, @RequestBody PatientDTO dto) throws Exception {
        Patient obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<PatientDTO> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Patient obj = service.findById(id);

        EntityModel<PatientDTO> resource = EntityModel.of(convertToDto(obj));

        WebMvcLinkBuilder link1 = linkTo(methodOn(PatientController.class).findById(obj.getIdPatient()));
        WebMvcLinkBuilder link2 = linkTo(methodOn(PatientController.class).findAll());

        resource.add(link1.withRel("patient-self-info"));
        resource.add(link2.withRel("patient-all-info"));

        return resource;
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Patient>> listPage(Pageable pageable)  {
        Page<Patient> page = service.listPage(pageable);

        return ResponseEntity.ok(page);
    }

    private Patient convertToEntity(PatientDTO dto){
        return modelMapper.map(dto, Patient.class);
    }

    private PatientDTO convertToDto(Patient entity){
        return modelMapper.map(entity, PatientDTO.class);
    }

    /*public PatientController(PatientService service) {
        this.service = service;
    }*/

    /*@GetMapping
    public Patient getPatient(){
        //service = new PatientService();

        return service.validAndReturn(5);
    }*/
}
