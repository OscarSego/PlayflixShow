package modelo;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PuntuacionPeliculaTest {

	@Test
	void testCalcularPuntuacion() {
		
		PuntuacionPelicula puntuacion = new PuntuacionPelicula();
		
        String nombrePelicula = "Batman";
        
        PuntuacionPelicula calculador = new PuntuacionPelicula();
        
        int resultado;
		try {
			resultado = calculador.CalcularPuntuacion(nombrePelicula);
			
	        int mediaEsperada = (5 + 5) / 2; 
	        assertEquals(mediaEsperada, resultado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}
