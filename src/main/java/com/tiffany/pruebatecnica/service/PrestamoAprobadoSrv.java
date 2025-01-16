package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.PagoDto;
import com.tiffany.pruebatecnica.dto.PrestamosAprobadosProjection;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.modelo.PrestamosAprobado;
import com.tiffany.pruebatecnica.repository.PrestamoAprobadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
@Transactional (rollbackFor = Exception.class)
    public void actualizarPrestamoAprobado (PagoDto pagoDto) {
    PrestamosAprobado prestamosAprobado = prestamoAprobadoRepository.obtenerPrestamoAprobado(pagoDto.getIdPrestamo()).get();
    prestamosAprobado.setFechaModificacion(Instant.now());
        prestamosAprobado.setUsuarioModifica(pagoDto.getUsuarioModifica());
        prestamosAprobado.setSaldoPendiente(calcularSaldoPendiente(prestamosAprobado.getSaldoPendiente(),pagoDto.getAbonoPrestamo()));

    }
    private BigDecimal calcularSaldoPendiente(BigDecimal saldoTotal, BigDecimal monto) {
        return saldoTotal.subtract(monto);

    }
    @Transactional (rollbackFor = Exception.class)
    public Prestamo obtenerPrestamoAprobado (Integer id) {
        Optional<PrestamosAprobado> prestamo = prestamoAprobadoRepository.obtenerPrestamoAprobado(id);
        if(!prestamo.isPresent()) {
            throw new RuntimeException("Prestamo no encontrado");
        }
        return
        prestamo.get().getIdPrestamo();
    }



}
