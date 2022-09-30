package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServicioImpl implements SucursalServices {
	
	//private final SucursalRepository sucursalRepository;
	
	@Autowired
	SucursalRepository sucursalRepository;
	
	@Override
	public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Sucursal sucursal = modelMapper.map(sucursalDTO, Sucursal.class);
		sucursal = sucursalRepository.save(sucursal);
		return modelMapper.map(sucursal, SucursalDTO.class);
	}

	@Override
	public List<SucursalDTO> getAllSucursal() {
		List<Sucursal>sucursales = sucursalRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		List<SucursalDTO> sucursalesDTOList = new ArrayList<>();
		for (Sucursal sucursal : sucursales) {
			SucursalDTO sucursalesDTO = modelMapper.map(sucursales, SucursalDTO.class);
			sucursalesDTOList.add(sucursalesDTO);
		}
		return sucursalesDTOList;
	}

	@Override
	public SucursalDTO getOneSucursal(Integer pk_SucursalID) {
		ModelMapper modelMapper = new ModelMapper();
		Sucursal sucursal = modelMapper.map(pk_SucursalID, Sucursal.class);
		sucursal = sucursalRepository.findById(pk_SucursalID).get();
		return modelMapper.map(sucursal, SucursalDTO.class);
	}

	@Override
	public SucursalDTO updateSucursal(Integer pk_SucursalID, SucursalDTO updateSucursal) {
		ModelMapper modelMapper = new ModelMapper();
		Sucursal sucursalBuscada = modelMapper.map(pk_SucursalID, Sucursal.class);
		sucursalBuscada = sucursalRepository.findById(pk_SucursalID).get();
		sucursalBuscada.setNomSucursal(updateSucursal.getNomSucursal());
		sucursalBuscada.setPaisSucursal(updateSucursal.getPaisSucursal());
		sucursalBuscada = sucursalRepository.save(sucursalBuscada);
		return modelMapper.map(sucursalBuscada, SucursalDTO.class);
	}

	@Override
	public boolean deleteSucursal(Integer pk_SucursalID) {
		try {
			sucursalRepository.deleteById(pk_SucursalID);
			return true;
		}catch (Exception e) {
		return false;
		}
	}

}

	