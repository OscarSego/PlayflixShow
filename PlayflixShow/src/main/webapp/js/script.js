  // Ruta para guardar las imagenes
      
    var ruta = "http://localhost:8080/PlayflixShow/imagenes/";
    
    // La siguiente parte del codigo permitira recoger la puntuacion y visualizarla
    
    const ajax = new XMLHttpRequest();
    
    function llamada(){
    	ajax.open("GET", "Puntuacion", true);
    	ajax.onreadystatechange = dameResponse;
    	ajax.send();
    }
    
    function dameResponse(){
    	if(ajax.readyState == 4){
    		if(ajax.status == 200){
    			let miPunt = "<p> La Puntuacion de la pelicula segun lus usuarios es: " + ajax.responseText + "</p>";
    			document.getElementById("puntuacion").innerHTML = miPunt; 
    		}
    	}
    }
    
    //Esta funcion nos permite recoger el nombre de la pelicula del buscador y visualizarla
    // Se llama al servlet para buscarla
    
    function obtenerPeliculas() {
 		
 		let nombre = document.getElementById("nombre").value;

     	fetch("BuscarPelicula?nombrePelicula="+nombre)
         	.then(res => res.json())
         	.then(res => pintarPeli(res));
 	}
	
    function pintarPeli(datos){
    	
    	let codigoHTML = "";
    	
    	codigoHTML += "<img src='imagenes/"+datos.imagenPeliculas+"'>";
    	

        document.getElementById("Peliculas").innerHTML = codigoHTML;  
        
        llamada();

    }

		// Funcion para pintar el nombre del usuario que ha iniciado sesion
		
        function pintarDato(datos){

            let listaNombre = "";

                listaNombre += "<p>" + datos.nombre + "</p>";

            document.getElementById("nombreUsuario").innerHTML = listaNombre;

        }
        
        // funcion que permite pintar el listado de peliculas
        
        function pintar(datos){

            let codigoHTML = "";

            for(var i=0;i<datos.length;i++){
                codigoHTML += "<img src='imagenes/"+datos[i].imagenPeliculas+"'>";
            }

            document.getElementById('Peliculas').innerHTML = codigoHTML;
        }
		
		// Aqui podremos cargar en la pagina los datos sin necesidad de dar a ningun boton
		
        window.onload = function(){
	
			// Llama a servlet Listado y a la funcion pintarDato
        	
            fetch('Listado')
                .then(res => res.json())
                .then(res => pintarDato(res));
                
             // Llama a servlet Peliculas y a la funcion pintar
            
             fetch('Peliculas')
            	.then(res => res.json())
            	.then(res => pintar(res));
             
  			// Nos permitira cerrar sesion
  			
             document.getElementById("cerrarSesion").addEventListener("click", function() {
                 
                 const ajax = new XMLHttpRequest();
                 ajax.open("GET", "CerrarSesion", true);
                 ajax.send();
                 
                 window.location.href = "index.html";
               });  
        
         }