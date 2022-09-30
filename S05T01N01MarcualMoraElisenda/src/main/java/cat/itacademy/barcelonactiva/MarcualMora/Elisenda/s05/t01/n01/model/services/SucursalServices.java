package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;


public interface SucursalServices {
	
	public SucursalDTO addSucursal(SucursalDTO sucursalDTO);
	
	public List<SucursalDTO> getAllSucursal ();
	
	public SucursalDTO getOneSucursal(Integer pk_SucursalID);
	
	public SucursalDTO updateSucursal (Integer pk_SucursalID, SucursalDTO updateSucursal);
	
	boolean deleteSucursal (Integer pk_SucursalID);
}
