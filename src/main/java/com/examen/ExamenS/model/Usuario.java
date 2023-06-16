package com.examen.ExamenS.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
@Entity
@Table(name="usuarios")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
 private Integer id;
 private String nombre;
 private String apellidoP;
 private String apellidoM;
 private Integer edad;
 private String email;
 private String telefono;
 private boolean estado;
 
public Usuario() {
}
 public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidoP() {
	return apellidoP;
}
public void setApellidoP(String apellidoP) {
	this.apellidoP = apellidoP;
}
public String getApellidoM() {
	return apellidoM;
}
public void setApellidoM(String apellidoM) {
	this.apellidoM = apellidoM;
}
public Integer getEdad() {
	return edad;
}
public void setEdad(Integer edad) {
	this.edad = edad;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}

}

