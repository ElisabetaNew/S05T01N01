package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;


public interface SucursalServices {
	
	public Integer addSucursal(SucursalDTO sucursalDTO);
	
	public List<SucursalDTO> getAllSucursal ();
	
	public SucursalDTO getOneSucursal(Integer pk_SucursalID);
	
	public SucursalDTO updateSucursal (Integer pk_SucursalID, SucursalDTO sucursalDTO);
	
	public int deleteSucursal (Integer pk_SucursalID);
}
