package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Jugador2 extends ObejtoJuego {
		
		private int vida;
		private HashMap<String, Animacion> animaciones;
		private int xImagen;
		private int yImagen;
		private int anchoImagen;
		private int altoImagen;
		private String animacionActual;
		private int direccion = 1;
		private int xP = 0;
		
		public Jugador2(int x, int y, String nombreImagen, int velocidad, int vida, String animacionActual) {
			super(x, y, nombreImagen, velocidad);
			this.vida = vida;
			this.animacionActual = animacionActual;
			animaciones = new HashMap<String, Animacion>();
			inicializarAnimaciones();
		}

		public int getDireccion() {
			return direccion;
		}
		public void setDireccion(int direccion) {
			this.direccion = direccion;
		}
		public int getxP() {
			return xP;

		}
		public void setxP(int xP) {
			this.xP = xP;
		}
		
		public int getVida() {
			return vida;
		}
		public void setVida(int vida) {
			this.vida = vida;
		}
		
		public void inicializarAnimaciones() {
			Rectangle coordenadasCorrer[] ={
					new Rectangle(601,195,54,53),
					new Rectangle(668,195,54,53),
					new Rectangle(735,195,54,53),
					new Rectangle(803,195,54,53),
					
					
				};
			Animacion animacionCorrer = new Animacion(0.15, coordenadasCorrer);
			animaciones.put("correr", animacionCorrer);
			
			
			
			Rectangle coordenadasDescanso[] = {
				new Rectangle (360,503,53,55),
				new Rectangle (425,503,53,55),
				new Rectangle (477,503,53,55),
				new Rectangle (540,503,53,55)
				
				
			};
			Animacion animacionDescanso = new Animacion(0.2, coordenadasDescanso);
			animaciones.put("descanso", animacionDescanso);
			
		}
		
		public void calcularFrame(double t) {
			Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
		    this.xImagen = (int)coordenadas.getX();
		    this.yImagen = (int)coordenadas.getY();
		    this.altoImagen = (int)coordenadas.getHeight();
		    this.anchoImagen = (int)coordenadas.getWidth();
		    
		}
		public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, (direccion*anchoImagen)-10, altoImagen);
	}
		
		

		@Override
		public void mover() {

		if (Juego.d)	{
			animacionActual = "correr";
			if (x>=1500 || ((x<1018&x>430)&y>=0&y<21)  || ((x<201&x>=140)&y>1&y<68) || ((x<370&x>=206)&y>83&y<117) ||((x<369&x>=289)&y>17&y<117) ||((x<1019&x>=469)&y>26&y<68)
					|| ((x<1500&x>=1460)&y>=0&y<230)   || ((x<1500&x>=1390)&y>=90&y<167) || ((x<1500&x>=1418)&y>=293&y<359) ||((x<1208&x>=1130)&y>=265&y<381) || ((x<1500&x>=1480)&y>=381&y<460)
					|| ((x<1500&x>=1182)&y>=381&y<445) ||((x<1500&x>=1444)&y>=445&y<479) || ((x<1444&x>=1384)&y>=475&y<540) || ((x<1500&x>=1470)&y>=575&y<654) || ((x<1334&x>=1258)&y>=651&y<693)
					|| ((x<1222&x>=1036)&y>=659&y<695) || ((x<1036&x>=1098)&y>=695&y<750) || ((x<1226&x>=1160)&y>=540&y<610) || ((x<1009&x>=772)&y>=593&y<655) || ((x<1009&x>=946)&y>=555&y<655)
					|| ((x<628&x>=260)&y>=696&y<750) || ((x<520&x>510)&y>=506&y<587)
					)
					 {
				x += 0 ;
			}else {
				x += velocidad;
			}
		}else if (Juego.a) {
			animacionActual = "correr";
			if (x<=0 || ((x<=202&x>140)&y>2&y<69) || ((x<=370&x>290)&y>17&y<117) || ((x<=1019&x>469)&y>0&y<68) || ((x<=1294&x>1226)&y>572&y<610) || ((x<=1226&x>1160)&y>540&y<609)
					|| ((x<=764&x>600)&y>515&y<588) || ((x<=1010&x>946)&y>555&y<655) || ((x<=788&x>260)&y>730&y<750) || ((x<=628&x>260)&y>696&y<750) || ((x<=155&x>150)&y>604&y<720)
					|| ((x<=190&x>155)&y>720&y<620) || ((x<=259&x>231)&y>632&y<600) || ((x<=284&x>259)&y>590&y<600) || ((x<=99&x>0)&y>540&y<585)  || ((x<=78&x>0)&y>700&y<770)
					
					) {
				x += 0 ;
			}else {
				x -= velocidad;
			}
			
		}else if (Juego.w) {
			animacionActual = "correr";
			if (y<=0 || ((y<=69&y>2)&x>140&x<202) || ((y<=117&y>83)&x>206&x<370) || ((y<=68&y>0)&x>469&x<1019)|| ((y<=26&y>0)&x>431&x<469)||((y<=20&y>0)&x>1019&x<1500) || ((y<=610&y>572)&x>1160&x<1294)
					 || ((y<=515&y>338)&x>754&x<1170) || ((y<=587&y>515)&x>506&x<745) || ((y<=655&y>593)&x>772&x<1009) ||((y<=720&y>700)&x>0&x<150) || ((y<=550&y>548)&x>98&x<269)
					 || ((y<=550&y>506)&x>447&x<516)  || ((y<=510&y>468)&x>422&x<470) || ((y<=468&y>424)&x>358&x<422) || ((y<=424&y>400)&x>146&x<344)
					
					) {
				y += 0 ;
			}else {
			y -= velocidad;
			}
			
		}else if (Juego.s) {
			animacionActual = "correr";
			if (y>=750 || ((y<140&y>61)&x<=46) ||((y<70&y>=1)&x>140&x<202) || ((y<117&y>=83)&x>206&x<370) || ((y<=117&y>16)&x>205&x<369) || ((y<=610&y>565)&x>1160&x<1294)|| ((y<=610&y>532)&x>1160&x<1226)
					|| ((y<655&y>=555)&x>946&x<1009) || ((y<655&y>=593)&x>772&x<1009) || ((y<750&y>=730)&x>260&x<788) || ((y<750&y>=696)&x>260&x<628) ||((y<585&y>=584)&x>98&x<269)
					
					
					) {
				y += 0 ;
			}else {
			y += velocidad;
			}
			
		}else {
			animacionActual = "descanso";
		}
			
			
			
		}
		

		@Override
		public String toString() {
			return "Jugador2 [x=" + x + ", y=" + y + ", vida=" + vida + ", nombreImagen=" + nombreImagen + ", velocidad="
					+ velocidad + "]";
		}


		public String getAnimacionActual() {
			return animacionActual;
		}


		public void setAnimacionActual(String animacionActual) {
			this.animacionActual = animacionActual;
		}
		


		@Override
		public void pintar(GraphicsContext graficos) {
			graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen, x+(anchoImagen*xP), y, direccion*anchoImagen/1.4, altoImagen/1.4);
			//   graficos.setFill(Color.RED);
			//	graficos.strokeRect(x, y, (direccion*anchoImagen)-10, altoImagen);
			
		}
		
		


}
