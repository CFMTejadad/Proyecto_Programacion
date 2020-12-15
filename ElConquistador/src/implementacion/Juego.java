package implementacion;



import java.util.HashMap;

import clases.Fondo;
import clases.Jugador;
import clases.Jugador2;
import clases.Jugador3;
import clases.JugadorAnimado;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Juego extends Application {
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
//	private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	private Jugador2 jugador2;
//	private Jugador jugador;
	private Jugador3 jugador3;
	private Fondo fondo;
	public static  boolean arriba;
	public static  boolean abajo;
	public static  boolean izquierda;
	public static  boolean derecha;
	public static  boolean a;
	public static  boolean w;
	public static  boolean s;
	public static  boolean d;
	public static  boolean t;
	public static  boolean g;
	public static  boolean f;
	public static  boolean h;
	public static HashMap<String,Image> imagenes;
	
	
	
	
	
	public static void main(String[] args) {
		 launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		imagenes =  new HashMap<String, Image>();
		inicializarComponentes();
		
		gestionEvento(); 
		ventana.setScene(escena);
		ventana.setTitle("El Conquistador");
		ventana.show();
		cicloJuego();
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer(){

			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual- tiempoInicial)/1000000000.0;
			//	System.out.println(t);
				actualizarEstado(t);
				 pintar();
				 
			}
			
		};
		animationTimer.start();
	}
	public void actualizarEstado(double t) {
		
		jugadorAnimado.mover();
		jugador2.calcularFrame(t);
        jugador3.calcularFrame(t);
		jugador3.mover();
		jugador2.mover();
		jugadorAnimado.calcularFrame(t);
		jugadorAnimado.mover();
		fondo.mover();  
		
	}
	
	
	
	public void inicializarComponentes() {
	//	imagenes = new HashMap<String, Image>();
		cargarImagenes();
//		jugador = new Jugador(20, 40, "TP1", 3, 0);
		jugadorAnimado = new JugadorAnimado(100, 75, "Tolupan", 1, 0,"descanso");
		jugador3 = new Jugador3 (1410, 680, "Chortis",2,0, "descanso");
		jugador2 = new Jugador2 (1410, 75, "Capitan",2,0, "descanso");
	//	jugador = new Jugador2 (132, 700, "Capitan",2,0, "descanso");
		
		
		fondo = new Fondo(0, 0, "Mapa1", 0);
	//	item = new Item (300,200,"Roca1",20,1);
	
	//	inicializarTile()
	//	tile = new Tile(0,0, "Mapa1",0,0,0,500,500);
		root = new Group();
		escena = new Scene(root, 1550, 700);
		lienzo = new Canvas(1550, 900);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	
	}

	
	
	public void cargarImagenes() {
		imagenes.put("TP1", new Image("TP1.png"));
		imagenes.put("Verde1", new Image("Verde1.jpg"));
		imagenes.put("Mapa1", new Image("Mapa1.png"));
		imagenes.put("Tolupan", new Image("Tolupan.png"));
		imagenes.put("Roca1", new Image("Roca1.png"));
		imagenes.put("Capitan", new Image("Capitan.png"));
		imagenes.put("Chortis",new Image( "Chortis.png"));
	}
	
	public void pintar() {
		fondo.pintar(graficos);
		jugadorAnimado.pintar(graficos);
		jugador2.pintar(graficos);
		jugador3.pintar(graficos);
		
	}
	public void gestionEvento() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
		@Override
		public void handle(KeyEvent evento) {
			switch(evento.getCode().toString()) {
			
			case "RIGHT" :
			derecha = true;
			jugadorAnimado.setDireccion(1);  
            jugadorAnimado.setxP(0);
			break;
			
			case "LEFT" :
				izquierda = true;
				jugadorAnimado.setDireccion(-1);  
				jugadorAnimado.setxP(1);
				break;
				
			case "UP":
				arriba = true;
				
				break;
				
			case "DOWN":
				abajo = true;
				
				break;
				
			case "H" :
				h = true;
				jugador3.setDireccion(1);  
	            jugador3.setxP(0);
				break;
				
				case "F" :
					f = true;
					jugador3.setDireccion(-1);  
					jugador3.setxP(1);
					break;
					
				case "T":
					t = true;
					
					break;
					
				case "G":
					g = true;
					
					break;
					
			}
			
       switch(evento.getCode().toString()) {
			
			case "D":
			d = true;
			jugador2.setDireccion(1);  
            jugador2.setxP(0);
			break;
			
			case "A" :
				a = true;
				jugador2.setDireccion(-1);  
				jugador2.setxP(1);
				break;
				
			case "W":
				w = true;
				
				break;
				
			case "S":
				s = true;
				
				break;
				
				
			}	
		
		}});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				switch(evento.getCode().toString()) {
				
				case "RIGHT":
				derecha = false;
			
				break;
				
				case "LEFT":
					izquierda = false;
				
					break;
					
				case "UP":
					arriba = false;
					break;
					
				case "DOWN":
					abajo = false;
					break;
				case "H":
					h = false;
				
					break;
					
					case "F":
						f = false;
					
						break;
						
					case "T":
						t = false;
						break;
						
					case "G":
						g = false;
						break;
				
				}
switch(evento.getCode().toString()) {
				
				case "D":
				d = false;
			//	jugadorAnimado.setAnimacionActual("descanso");
				break;
				
				case "A":
					a = false;
				//	jugadorAnimado.setAnimacionActual("descanso");
					break;
					
				case "W":
					w = false;
					break;
					
				case "S":
					s = false;
					break;
				
				}
			}
			
		
		});
	

}

}












