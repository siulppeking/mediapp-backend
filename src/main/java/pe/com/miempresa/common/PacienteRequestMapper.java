/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.miempresa.common;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pe.com.miempresa.dto.PacienteRequest;
import pe.com.miempresa.entities.Paciente;

/**
 *
 * @author lescobar
 */
@Mapper(componentModel = "spring")
public interface PacienteRequestMapper {

    @Mappings({
        @Mapping(source = "nombres", target = "nombres")})
    Paciente PacienteRequestToPaciente(PacienteRequest source);

    List<Paciente> PacienteRequestListToPacienteList(List<PacienteRequest> source);

    @InheritInverseConfiguration
    PacienteRequest PacienteToPacienteRequest(Paciente source);

    @InheritInverseConfiguration
    List<PacienteRequest> PacienteListToPacienteRequestList(List<Paciente> source);

}
