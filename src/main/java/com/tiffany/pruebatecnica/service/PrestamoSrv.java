package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.AprobarPrestamoDto;
import com.tiffany.pruebatecnica.dto.PrestamoDto;
import com.tiffany.pruebatecnica.dto.RechazaPrestamoDto;
import com.tiffany.pruebatecnica.dto.SolicitudPrestamoProjection;
import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.repository.PrestamoRepository;
import com.tiffany.pruebatecnica.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoSrv {
    @Autowired
    ClienteSrv clienteSrv;
    @Autowired
    PrestamoRepository prestamoRepository;
    @Autowired
    PrestamoAprobadoSrv prestamoAprobadoSrv;

    public Integer crearPrestamoSrv(PrestamoDto prestamoDto) {
        Cliente cliente = clienteSrv.buscarClientePorId(prestamoDto.getIdCliente());
        Prestamo prestamo = new Prestamo(prestamoDto, cliente);
        Prestamo prestamoGuardar = prestamoRepository.save(prestamo);
        return prestamoGuardar.getId();
    }

    public List<SolicitudPrestamoProjection> ListaPrestamo(Integer idCliente) {
        return prestamoRepository.listaSolicitudPrestamo(idCliente);


    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void aprobarPrestamo(AprobarPrestamoDto aprobarPrestamoDto) {
        verificarExistePrestamo(aprobarPrestamoDto.getIdPrestamo());
        Prestamo prestamo = prestamoRepository.findById(aprobarPrestamoDto.getIdPrestamo()).get();
        prestamo.setEstado(Constantes.APROBADO);
        prestamo.setFechaModifica(LocalDate.now());
        prestamo.setUsuarioAprueba(aprobarPrestamoDto.getUsuarioAprueba());
        prestamo.setDetalleAprobacion(aprobarPrestamoDto.getComentario());
        prestamoAprobadoSrv.GuardarPrestamoAprobado(prestamo);

    }

    public void verificarExistePrestamo(Integer idPrestamo) {
        if (!prestamoRepository.existsById(idPrestamo)) {
            throw new RuntimeException("Prestamo no encontrado");
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void rechazarPrestamo(RechazaPrestamoDto rechazaPrestamoDto) {
        verificarExistePrestamo(rechazaPrestamoDto.getIdPrestamo());
        Prestamo prestamo = prestamoRepository.findById(rechazaPrestamoDto.getIdPrestamo()).get();
        prestamo.setEstado(Constantes.RECHAZADO);
        prestamo.setFechaModifica(LocalDate.now());
        prestamo.setUsuarioAprueba(rechazaPrestamoDto.getUsuarioRechaza());
        prestamo.setDetalleAprobacion(rechazaPrestamoDto.getComentario());

    }
}
