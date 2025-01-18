package com.tiffany.pruebatecnica.service;


import com.tiffany.pruebatecnica.dto.CataloHijoProjection;
import com.tiffany.pruebatecnica.repository.CatalogoHijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogoSrv {

    @Autowired
    CatalogoHijoRepository hijoRepo;


    @Transactional(readOnly = true)
    public List<CataloHijoProjection> obtenerCatalogoHijoByPadre(Integer idPadre) {


        return this.hijoRepo.obtenerCatalogoHijobyPadre(idPadre);
    }
}
