package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.app.Test;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.controllers.CotxeSerialitzacioController;

public class Test {

	public static void main(String[] args) {
		
		CotxeSerialitzacioController cotxeSerialitzacioController = CotxeSerialitzacioController.getInstance();
		cotxeSerialitzacioController.serialitzaUnCotxe();
		cotxeSerialitzacioController.deserialitzaUnCotxe();
		cotxeSerialitzacioController.serialitzaLlistaCotxes();
		cotxeSerialitzacioController.deserialitzaLlistaCotxes();

	}

}
