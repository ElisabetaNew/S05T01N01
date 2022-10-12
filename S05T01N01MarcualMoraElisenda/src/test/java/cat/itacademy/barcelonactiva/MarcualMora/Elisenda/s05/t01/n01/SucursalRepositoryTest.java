package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.repository.SucursalRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SucursalRepositoryTest {

	@Autowired
	private SucursalRepository repositorio; 
	
	@Test
	public void saveSucursal() {
		Sucursal sucursal1 = new Sucursal("Hotel Azul", "Italia");
		Sucursal sucursal2 = new Sucursal("Hotel Lila", "Marruecos");
		
		repositorio.save(sucursal1);
		repositorio.save(sucursal2);
		
		//para que los inserte al momento
		repositorio.flush();
		
		//comprobacion. Si lo graba correctamente tenemos que tener dos registros.
		assertEquals(2, repositorio.findAll().size());
		
		//Cuando lo ejecutamos "Rolled back transantion for test". En la tabla no existiran los registros. Solo son para test.
	}
}
