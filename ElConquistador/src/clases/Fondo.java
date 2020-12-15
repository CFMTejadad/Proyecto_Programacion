package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObejtoJuego {
	
	
	public Fondo(int x, int y, String nombreImagen, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), this.x, this.y);
	}
	
	@Override
	public void mover () {
		if (Juego.derecha)
			this.x -= velocidad;
		
		if (Juego.izquierda)
			this.x += velocidad;
		
		if (Juego.arriba)
			this.y += velocidad;
		
		if (Juego.abajo)
			this.y -= velocidad;
	}
	
	
}
