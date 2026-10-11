package com.cibertec.paciente.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("paciente")
public class Paciente {

    @Id
    private Long id;

    @Column("tipo_documento")
    private String tipoDocumento;

    @Column("numero_documento")
    private String numeroDocumento;

    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String estado;
}