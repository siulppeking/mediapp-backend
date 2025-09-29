/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.miempresa.entities.Medico;

/**
 *
 * @author dukz
 */
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
