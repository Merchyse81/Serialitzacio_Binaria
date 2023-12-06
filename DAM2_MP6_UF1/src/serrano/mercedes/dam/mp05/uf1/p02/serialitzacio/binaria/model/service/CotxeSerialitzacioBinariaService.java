package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.configuration.Settings;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.domain.Cotxe;


public class CotxeSerialitzacioBinariaService {
	
	private CotxeSerialitzacioBinariaService() {
		
	}
	
	public static CotxeSerialitzacioBinariaService getInstance() {
		if(instance == null) {
			instance = new CotxeSerialitzacioBinariaService();
		}
		return instance;
	}
	
	private static CotxeSerialitzacioBinariaService instance = null;
	
	public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(Settings.FICHERO_COTXE_INDIVIDUAL);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(cotxe);
        objectOut.close();
        fileOut.close();
    }

    public void serialitzaLlistaCotxes(List<Cotxe> cotxes) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(Settings.FICHERO_LLISTA_COTXES);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(cotxes);
        objectOut.close();
        fileOut.close();
    }

    public Cotxe deserialitzaUnCotxe() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(Settings.FICHERO_COTXE_INDIVIDUAL);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Cotxe cotxe = (Cotxe) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return cotxe;
    }

    public List<Cotxe> deserialitzaLlistaCotxes() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(Settings.FICHERO_LLISTA_COTXES);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        List<Cotxe> cotxes = (List<Cotxe>) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return cotxes;
    }

}


