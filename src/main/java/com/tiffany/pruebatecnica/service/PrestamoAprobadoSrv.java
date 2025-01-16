package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.PrestamosAprobadosProjection;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.modelo.PrestamosAprobado;
import com.tiffany.pruebatecnica.repository.PrestamoAprobadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PrestamoAprobadoSrv {
    @Autowired
    PrestamoAprobadoRepository prestamoAprobadoRepository;
    public void GuardarPrestamoAprobado (Prestamo prestamo) {
        PrestamosAprobado prestamosAprobado = new PrestamosAprobado(prestamo);
        prestamoAprobadoRepository.save(prestamosAprobado);
    }
    public List<PrestamosAprobadosProjection> obtenerPrestamoAprobados() {
        return prestamoAprobadoRepository.listaPrestamoAprobados();

    }

}
