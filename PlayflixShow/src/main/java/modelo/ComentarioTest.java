package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ComentarioTest {

	@Test
    public void testTamanioComentarioMenosDe400() {
        // Arrange
        String comentario = "Este es un comentario de prueba.";
        String respuestaEsperada = "El texto tiene menos de 400 caracteres.";

        Comentario comen = new Comentario();
        
        String respuestaActual = comen.tamanioComentario(comentario);

        
        assertEquals(respuestaEsperada, respuestaActual);
    }
	
    @Test
    public void testTamanioComentario400OMas() {
        
        String comentario = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.";
        String respuestaEsperada = "El texto tiene 400 o más caracteres.";

        Comentario comen = new Comentario();
        
        String respuestaActual = comen.tamanioComentario(comentario);

        
        assertEquals(respuestaEsperada, respuestaActual);
    }

}
