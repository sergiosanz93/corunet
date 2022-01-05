package com.ssanz.corunet.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EntradaDatosVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaAplicacion;
	private Integer idProducto;
	private Integer idCadena;
	
	public EntradaDatosVO(Date fechaAplicacion, Integer idProducto, Integer idCadena) {
		this.fechaAplicacion = fechaAplicacion;
		this.idProducto = idProducto;
		this.idCadena = idCadena;
		
	}
	public EntradaDatosVO() {
		super();
	}
	
	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdCadena() {
		return idCadena;
	}
	public void setIdCadena(Integer idCadena) {
		this.idCadena = idCadena;
	}
	
	

}
