package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserClienteSrv {
    @Autowired
    ClienteSrv clienteSrv ;
    @Autowired
    UserSrv userSrv ;
    @Autowired
    private EmpleadoSrv empleadoSrv;

    @Transactional (readOnly=false, rollbackFor=Exception.class)
    public void GuardarCliente(ClienteDto cliente) {


        Integer idCliente = userSrv.save(cliente);
        clienteSrv.save(cliente,idCliente);

    }
    @Transactional (readOnly=false, rollbackFor=Exception.class)
    public void GuardarEmpleado(EmpleadoDto empleado) {
        Integer idCliente = userSrv.saveUserEmpleado(empleado);
        empleadoSrv.save(empleado,idCliente);


}
}