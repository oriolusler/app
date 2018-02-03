package com.app.app.DaoController;

import com.app.app.Domini.Oferta;
import com.app.app.Persistencia.OfertaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ofertaController")
public class OfertaDAOController {

    private OfertaDAO ofertaDAO;

    public OfertaDAOController(OfertaDAO ofertaDAO) {
        this.ofertaDAO = ofertaDAO;
    }

    public List<Oferta> getAll() {
        return ofertaDAO.all();
    }
}
