package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ClienteSrv {
@Autowired
    ClienteRepository clienteRepository;

@Transactional (readOnly = false, rollbackFor = Exception.class)
public void save(ClienteDto clienteDto, int idUsuario) {
    log.info("guardando cliente en bd");
    verificarDocumentoDeIdentificacionEnUso(clienteDto.getNumeroIdentificacion());
    correoElectronicoEnUso(clienteDto.getCorreoElectronico());

 Cliente cliente = new Cliente(idUsuario, clienteDto);
 clienteRepository.save(cliente);

}




public void verificarDocumentoDeIdentificacionEnUso(String documentoDeIdentificacion) {
    if (clienteRepository.existsByNumeroIdentificacion(documentoDeIdentificacion)) {
        throw new RuntimeException("El documento de identificacion ya existe");
    }


}

public void correoElectronicoEnUso(String correoElectronico) {
    if (clienteRepository.existsByCorreoElectronico(correoElectronico)) {
        throw new RuntimeException("El correo de electronico ya existe");
    }


}



}
