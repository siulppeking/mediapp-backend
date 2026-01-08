package com.mitocode.service;

import com.mitocode.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService extends ICRUD<Patient, Integer> {

    Page<Patient> listPage(Pageable pageable);
    //CRUD: Create, Read, Update, Delete
    /*Patient save(Patient patient) throws Exception;
    Patient update(Integer id, Patient patient) throws Exception;
    List<Patient> findAll() throws Exception;
    Patient findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;*/

    //Patient validAndReturn(Integer id);
}
