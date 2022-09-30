package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable{



	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_IdSucursal")
	private int pk_SucursalID;
	
	@Column(name="NomSucursal", length = 150, nullable=false)
	private String nomSucursal;
	
	@Column(name="PaisSucursal", length = 100)
	private String paisSucursal;
	
	//constructores
	public Sucursal() {
		
	}
	
	public Sucursal(String nomSucursal, String paisSucursal) {
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	//getter y setter
	public int getPk_SucursalID() {
		return pk_SucursalID;
	}
	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	
	
}
