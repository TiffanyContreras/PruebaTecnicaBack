package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.InformacionClienteProjection;
import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.repository.ClienteRepository;
import com.tiffany.pruebatecnica.repository.PrestamoRepository;
import com.tiffany.pruebatecnica.repository.UserRepository;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClienteSrv {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    UserRepository usuarioRepository;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
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

    public List<InformacionClienteProjection> listarClientes() {
        return clienteRepository.listaClienteRegistrado();

    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void ActualizarCliente(ClienteDto clienteDto, Integer id) {
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setApellidoCliente(clienteDto.getApellidoCliente());
        cliente.setNombreCliente(clienteDto.getNombreCliente());
        cliente.setNumeroIdentificacion(clienteDto.getNumeroIdentificacion());
        cliente.setNumeroTelefono(clienteDto.getNumeroTelefono());
        cliente.setDireccionCliente(clienteDto.getDireccionCliente());
        cliente.setCorreoElectronico(clienteDto.getCorreoElectronico());
        //cliente.setMunicipio(clienteDto.getMunicipio());
        //cliente.setDepartamento(clienteDto.getDepartamento());


    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
        log.info("Cantidad de solicitudes de prestamos eliminados {}  para el cliente {}", prestamoRepository.eliminarSolicitudPretamoNoAprobadas(id), id);
        log.info("eliminando usuario");
        this.usuarioRepository.deleteById(id);

    }

    public Cliente buscarClientePorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();

        } else {
            throw new RuntimeException("El cliente no existe");
        }
    }
}
