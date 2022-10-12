package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServicioImpl implements SucursalServices {

	@Autowired
	SucursalRepository sucursalRepository;

	@Override
	public Integer addSucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = this.mapDTOtoEntity(sucursalDTO);
		sucursal = sucursalRepository.save(sucursal);
		return sucursal.getPk_SucursalID();
	}

	@Override
	public List<SucursalDTO> getAllSucursal() {
		List<Sucursal> sucursales = sucursalRepository.findAll();
		return this.getDTOBySucursales(sucursales);
	}

	@Override
	public SucursalDTO getOneSucursal(Integer pk_SucursalID) {

		SucursalDTO dto = null;
		Optional<Sucursal> sucursal = sucursalRepository.findById(pk_SucursalID); // Optional = puede existir o no
		if (sucursal.isPresent()) {
			dto = this.mapEntitytoDTO(sucursal.get());
		} else {
			dto = new SucursalDTO(); // para no pasarselo vacia
		}
		return dto;
	}
	
	@Override
	public SucursalDTO updateSucursal(Integer pk_SucursalID, SucursalDTO sucursalDTO) {
		
		SucursalDTO sucursalBuscada = this.getOneSucursal(pk_SucursalID);
		Sucursal sucursal = this.mapDTOtoEntity(sucursalDTO);
		sucursal = sucursalRepository.save(sucursal);
		sucursalBuscada = this.mapEntitytoDTO(sucursal);
		return sucursalBuscada;
	}

	@Override
	public int deleteSucursal(Integer pk_SucursalID) {
		try {
			sucursalRepository.deleteById(pk_SucursalID);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// para convertir valores nulos en "" para no tener problemas al lanzar otros
	// metodos
	private String convertNulltoEmpty(String value) {
		String result = "";
		if (value != null) {
			result = value;
		}
		return result;
	}

	// convierte en SucursalDTO los datos que llegan de la BBDD (Sucursal)
	private SucursalDTO mapEntitytoDTO(Sucursal sucursal) {
		SucursalDTO dto = new SucursalDTO();
		dto.setPk_SucursalID(sucursal.getPk_SucursalID());
		dto.setNomSucursal(sucursal.getNomSucursal());
		dto.setPaisSucursal(sucursal.getPaisSucursal());

		boolean encontrado = false;
		int i = 0;

		List<String> listaPaises = Arrays.asList(dto.getLlistaPaises());
		while (encontrado == false && i < listaPaises.size()) {
			if (dto.getPaisSucursal().equalsIgnoreCase(listaPaises.get(i))) {
				dto.setTipusSucursal("UE");
				encontrado = true;
			}
			i++;
		}
		dto.setTipusSucursal("ForaUE");
		return dto;
	}

	// convierte en Sucursal los datos que llegan de la vista (SucursalDTO) para
	// poderlos volcar a la BBDD
	private Sucursal mapDTOtoEntity(SucursalDTO dto) {
		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(dto.getPk_SucursalID());
		sucursal.setNomSucursal(dto.getNomSucursal());
		sucursal.setPaisSucursal(dto.getPaisSucursal());

		return sucursal;
	}

	// devuelve lista de SucursalesDTO a partir de lista de sucursales (entity)
	private ArrayList<SucursalDTO> getDTOBySucursales(List<Sucursal> sucursales) {
		ArrayList<SucursalDTO> sucursalesdto = null;
		if (sucursales != null) {
			sucursalesdto = new ArrayList<SucursalDTO>();

			for (Sucursal s : sucursales) {
				SucursalDTO dto = this.mapEntitytoDTO(s);

				sucursalesdto.add(dto);
			}
		}
		return sucursalesdto;
	}
}
