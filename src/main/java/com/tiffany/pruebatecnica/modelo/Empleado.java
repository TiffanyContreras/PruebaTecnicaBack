package com.tiffany.pruebatecnica.modelo;

import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "empleados", schema = "app_prestamo")
@NoArgsConstructor
public class Empleado {
    @Id
    @Column(name = "id_empleado", nullable = false)
    private Integer id;



    @Nationalized
    @Column(name = "nombre_empleado", nullable = false, length = 100)
    private String nombreEmpleado;

    @Nationalized
    @Column(name = "apellido_empleado", nullable = false, length = 100)
    private String apellidoEmpleado;

    public Empleado(Integer id, EmpleadoDto empleadoDto) {
        this.id = id;
        this.nombreEmpleado = empleadoDto.getNombre();
        this.apellidoEmpleado = empleadoDto.getApellido();
    }
}