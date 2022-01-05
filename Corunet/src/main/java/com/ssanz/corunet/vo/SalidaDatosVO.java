package com.ssanz.corunet.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssanz.corunet.entity.Brand;

public class SalidaDatosVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idProducto;
	private Integer idCadena;
	private String nombreCadena;
	private Integer idTarifa;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startFecha;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endFecha;
	private Float precio;
	private String moneda;
	
	public SalidaDatosVO(Integer idProducto, Brand cadena, Integer idTarifa, Date startFecha, Date endFecha,
			Float precio, String moneda) {
		this.idProducto = idProducto;
		this.idCadena = cadena.getId();
		this.nombreCadena = cadena.getName();
		this.idTarifa = idTarifa;
		this.startFecha = startFecha;
		this.endFecha = endFecha;
		this.precio = precio;
		this.moneda = moneda;
	}
	
	/**
	 * Getters y Setters
	 */

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

	public String getNombreCadena() {
		return nombreCadena;
	}

	public void setNombreCadena(String nombreCadena) {
		this.nombreCadena = nombreCadena;
	}

	public Integer getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Integer idTarifa) {
		this.idTarifa = idTarifa;
	}

	public Date getStartFecha() {
		return startFecha;
	}

	public void setStartFecha(Date startFecha) {
		this.startFecha = startFecha;
	}

	public Date getEndFecha() {
		return endFecha;
	}

	public void setEndFecha(Date endFecha) {
		this.endFecha = endFecha;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
		
}
