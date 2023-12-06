package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.binaria.model.domain.Cotxe;


public class CotxeSerialitzacioRepository {

    private CotxeSerialitzacioRepository() {
    }

    public static CotxeSerialitzacioRepository getInstance() {
        if (instance == null) {
            instance = new CotxeSerialitzacioRepository();
        }
        return instance;
    }

    private static CotxeSerialitzacioRepository instance = null;

    public void serialitzacioUnCotxe(Cotxe cotxe, String nomFitxer) throws IOException {
        CommonSerialitzacioBinariaRepository.getInstance().serialitza(cotxe, nomFitxer);
    }

    public Cotxe deserialitzaUnCotxe(String nomFitxer) throws IOException, ClassNotFoundException {
        Object object = CommonSerialitzacioBinariaRepository.getInstance().deserialitza(nomFitxer);
        if (object instanceof Cotxe) {
            return (Cotxe) object;
        }
        return null;
    }

    public void serialitzaLlistaCotxes(List<Cotxe> cotxes, String nomFitxer) throws IOException {
        Cotxe[] arrayCotxes = cotxes.toArray(new Cotxe[0]);
        CommonSerialitzacioBinariaRepository.getInstance().serialitza(arrayCotxes, nomFitxer);
    }

    public List<Cotxe> deserialitzaLlistaCotxes(String nomFitxer) throws IOException, ClassNotFoundException {
        Object object = CommonSerialitzacioBinariaRepository.getInstance().deserialitza(nomFitxer);
        if (object instanceof Cotxe[]) {
            Cotxe[] arrayCotxes = (Cotxe[]) object;
            return List.of(arrayCotxes);
        }
        return null;
    }
}