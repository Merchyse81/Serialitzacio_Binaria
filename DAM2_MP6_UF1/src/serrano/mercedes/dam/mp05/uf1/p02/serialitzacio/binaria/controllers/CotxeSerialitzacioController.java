package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.controllers;

import java.io.IOException;
import java.util.List;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.configuration.Settings;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.domain.Cotxe;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.service.CotxeSerialitzacioBinariaService;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.view.FormulariCotxeView;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.view.UtilitatsSortidaView;

public class CotxeSerialitzacioController {
	
	

	private CotxeSerialitzacioController() {

	}

	public static CotxeSerialitzacioController getInstance() {
		if (instance == null) {
			instance = new CotxeSerialitzacioController();
		}
		return instance;
	}

	private static CotxeSerialitzacioController instance = null;

	FormulariCotxeView formulariCotxeView = FormulariCotxeView.getInstance();
	CotxeSerialitzacioBinariaService service = CotxeSerialitzacioBinariaService.getInstance();
	UtilitatsSortidaView utilitatsSortidaView = UtilitatsSortidaView.getInstance();

	public void serialitzaUnCotxe() {
		
		System.out.println("Ruta del archivo de un cotxe: " + Settings.FICHERO_COTXE_INDIVIDUAL);

		try {
			titol("Serialitza un cotxe");
			Cotxe cotxe = formulariCotxeView.getCotxe();
			service.serialitzaUnCotxe(cotxe);
			utilitatsSortidaView.show("Cotxe serialitzat correctament", false);

		} catch (Exception e) {
			utilitatsSortidaView.show(e.getMessage(), true);
		}

	}

	public void serialitzaLlistaCotxes() {

		try {
			titol("Serialitza una llista de cotxes");
			List<Cotxe> cotxes = formulariCotxeView.getCotxes();
			service.serialitzaLlistaCotxes(cotxes);
			utilitatsSortidaView.show("Llista Cotxes serialitzada correctament", false);

		} catch (Exception e) {
			utilitatsSortidaView.show(e.getMessage(), true);
		}

	}

	public void deserialitzaUnCotxe() {
		try {
			titol("Deserialitza un cotxe");
			Cotxe cotxe = service.deserialitzaUnCotxe();
			utilitatsSortidaView.show(cotxe.toString(), false);

		} catch (Exception e) {
			utilitatsSortidaView.show(e.getMessage(), true);
		}

	}

	public void deserialitzaLlistaCotxes() {

		try {
			titol("Deserialitza una llista de cotxes");
			List<Cotxe> cotxes = service.deserialitzaLlistaCotxes();
			utilitatsSortidaView.show(cotxes.toString(), false);

		} catch (Exception e) {
			utilitatsSortidaView.show(e.getMessage(), true);
		}
	}

	private void titol(String accio) {
		utilitatsSortidaView.show("===========================", true);
		utilitatsSortidaView.show("Serialitar/Deserialitzar - Binari - " + accio, true);
		utilitatsSortidaView.show("===========================", true);
	}
}
