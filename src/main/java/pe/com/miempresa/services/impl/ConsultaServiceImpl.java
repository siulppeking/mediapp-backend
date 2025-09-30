/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.miempresa.services.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.miempresa.dto.ConsultaListaExamenDTO;
import pe.com.miempresa.entities.Consulta;
import pe.com.miempresa.repositories.ConsultaRepository;
import pe.com.miempresa.repositories.IConsultaExamenRepo;
import pe.com.miempresa.services.ConsultaService;

/**
 *
 * @author lescobar
 */
@Service
public class ConsultaServiceImpl implements ConsultaService {
    
    @Autowired
    private ConsultaRepository repo;
    
    @Autowired
    private IConsultaExamenRepo ceRepo;
    
    @Transactional
    @Override
    public Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO) {
        consultaDTO.getConsulta().getDetalleConsulta().forEach(det -> det.setConsulta(consultaDTO.getConsulta()));
        repo.save(consultaDTO.getConsulta());
        
        consultaDTO.getListExamen().forEach(ex -> ceRepo.registrar(consultaDTO.getConsulta().getIdConsulta(), ex.getIdExamen()));
        return consultaDTO.getConsulta();
    }
    
    @Override
    public Consulta registrar(Consulta obj) {
        obj.getDetalleConsulta().forEach(det -> {
            det.setConsulta(obj);
        });

        /*for(DetalleConsulta det : obj.getDetalleConsulta()) {
			det.setConsulta(obj);
		}*/
        return repo.save(obj);
    }
    
    @Override
    public Consulta modificar(Consulta obj) {
        return repo.save(obj);
    }
    
    @Override
    public List<Consulta> listar() {
        return repo.findAll();
    }
    
    @Override
    public Consulta leerPorId(Integer id) {
        return repo.findById(id).get();
    }
    
    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
    
}
