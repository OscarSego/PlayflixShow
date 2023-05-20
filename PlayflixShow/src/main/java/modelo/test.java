package modelo;

import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		PuntuacionPelicula P = new PuntuacionPelicula();
		
		int test = P.CalcularPuntuacion("Batman");
		
		System.out.println(test);
	}

}
