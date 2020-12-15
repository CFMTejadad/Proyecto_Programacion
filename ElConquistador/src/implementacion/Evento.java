package implementacion;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Evento implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent evento) {
		System.out.println("Se presiona una tecla:" + evento.getCode());
		
	}

}
