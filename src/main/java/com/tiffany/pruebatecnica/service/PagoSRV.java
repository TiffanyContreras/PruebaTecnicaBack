package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.PagoDto;
import com.tiffany.pruebatecnica.modelo.Pago;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.modelo.PrestamosAprobado;
import com.tiffany.pruebatecnica.repository.PagoRepository;
import com.tiffany.pruebatecnica.repository.PrestamoAprobadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoSRV {
    @Autowired
    PagoRepository pagoRepository;
    @Autowired
    PrestamoAprobadoSrv prestamoAprobadoSrv;

   public void pagar (PagoDto pago) {
       Prestamo prestamo = this.prestamoAprobadoSrv.obtenerPrestamoAprobado(pago.getIdPrestamo());
              Pago pagoGuardar = new Pago(pago,prestamo);
       this.pagoRepository.save(pagoGuardar);
       this.prestamoAprobadoSrv.actualizarPrestamoAprobado(pago);


   }


}
