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
import pe.com.miempresa.dto.PacienteResponse;
import pe.com.miempresa.entities.Paciente;

/**
 *
 * @author lescobar
 */
@Mapper(componentModel = "spring")
public interface PacienteResponseMapper {

    @Mappings({
        @Mapping(source = "nombres", target = "nombres")})
    Paciente PacienteResponseToPaciente(PacienteResponse source);

    List<Paciente> PacienteResponseListToPacienteList(List<PacienteResponse> source);

    @InheritInverseConfiguration
    PacienteResponse PacienteToPacienteResponse(Paciente source);

    @InheritInverseConfiguration
    List<PacienteResponse> PacienteListToPacienteResponseList(List<Paciente> source);

}
