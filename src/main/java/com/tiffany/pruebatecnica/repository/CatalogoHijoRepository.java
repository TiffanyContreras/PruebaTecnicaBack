package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.dto.CataloHijoProjection;
import com.tiffany.pruebatecnica.modelo.CatalogoHijo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogoHijoRepository extends CrudRepository<CatalogoHijo, Integer> {


    @Query(value = "select ch.id_hijo id,ch.nombre  from app_prestamo.catalogo_hijo ch \n" +
            "where ch.id_padre =:idPadre", nativeQuery = true)
    public List<CataloHijoProjection> obtenerCatalogoHijobyPadre(@Param("idPadre") Integer idPadre);
}
