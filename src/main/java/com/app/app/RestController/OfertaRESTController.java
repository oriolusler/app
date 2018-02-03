package com.app.app.RestController;

import com.app.app.DaoController.OfertaDAOController;
import com.app.app.Domini.Oferta;
import com.app.app.Domini.Puntuacio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("oferta/")
public class OfertaRESTController {

    private OfertaDAOController ofertaDAOController;

    public OfertaRESTController(OfertaDAOController ofertaDAOController) {
        this.ofertaDAOController = ofertaDAOController;
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Oferta> listOfertes() {
        return ofertaDAOController.getAll();
    }
}
