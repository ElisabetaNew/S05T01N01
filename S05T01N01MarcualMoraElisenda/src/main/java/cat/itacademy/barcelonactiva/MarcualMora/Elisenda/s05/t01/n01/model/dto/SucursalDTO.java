package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class SucursalDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private String[] llistaPaises= {"Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia",
				"Irlanda", "Letonia", "Luxemburgo", "PaísesBajos", "Suecia", "Bulgaria", "Eslovaquia",
				"Estonia", "Grecia", "Malta", "Polonia", "RepúblicaCheca", "Austria", "Chipre",
				"Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania", "Portugal", "Rumanía"};
	
	public SucursalDTO(int pk_SucursalID, String nomSucursal, String paisSucursal, String tipusSucursal) {
		super();
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = tipusSucursal;
	}
	
	public SucursalDTO() {
		
	}
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
	public String getTipusSucursal() {
		return tipusSucursal;
	}
	
	public void setTipusSucursal(String tipusSucursal) {
		
		boolean encontrado = false;
		int i = 0;
		
		List<String> listaPaises = Arrays.asList(this.llistaPaises);
		while (encontrado==false && i<listaPaises.size()) {
				if(this.paisSucursal.equalsIgnoreCase(listaPaises.get(i))) {
					tipusSucursal="UE";	
					encontrado = true;
					} i++; 
		} tipusSucursal = "ForaUE";
		this.tipusSucursal = tipusSucursal;
	}

	@Override
	public String toString() {
		return "SucursalDTO [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + ", tipusSucursal=" + tipusSucursal + "]";
	}


	
}
