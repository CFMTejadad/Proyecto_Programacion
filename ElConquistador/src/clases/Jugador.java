package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Jugador extends ObejtoJuego{
	private int vida;

	public Jugador(int x, int y, String nombreImagen, int velocidad, int vida) {
		super(x, y, nombreImagen, velocidad);
		this.vida = vida;
		
	}

	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	 
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
	}
	
	@Override
	public void mover() {
		if (x>700)
			x=-80;
		
		if (Juego.derecha)
			x += velocidad;
		
		if (Juego.izquierda)
			x -= velocidad;
		
		if (Juego.arriba)
			y -= velocidad;
		
		if (Juego.abajo)
			y += velocidad;	
	}
	
	@Override
	public String toString() {
		return "Jugador [x=" + x + ", y=" + y + ", vida=" + vida + ", nombreImagen=" + nombreImagen + ", velocidad="
				+ velocidad + "]";
	}
	
	

}
