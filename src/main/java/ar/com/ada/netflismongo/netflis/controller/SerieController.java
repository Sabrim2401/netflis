package ar.com.ada.netflismongo.netflis.controller;

import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.netflismongo.netflis.entities.Episodio;
import ar.com.ada.netflismongo.netflis.entities.Serie;
import ar.com.ada.netflismongo.netflis.model.response.GenericResponse;
import ar.com.ada.netflismongo.netflis.service.SerieService;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SerieController {

    @Autowired
    SerieService serieService;

    @GetMapping( "/netflismongo/series")
    public ResponseEntity<List<Serie>> getSeries() {

        List<Serie> series = serieService.traerSeries();

        return ResponseEntity.ok(series);

    }

    @PostMapping("/api/series")
    public ResponseEntity<?> crearSerie(@RequestBody Serie serie) {
        
        GenericResponse r = new GenericResponse();
        serieService.crearSerie(serie);
        r.id = serie.get_id().toHexString();
        r.isOk = true;
        r.message = "Serie creada con exito";
        return ResponseEntity.ok(r);
    }
    

    
    @GetMapping( "/api/series/{serieId}/temporada/{numeroTemporada}/episodio/{numeroEpisodio}")
    public ResponseEntity<Episodio> getSeries(@PathVariable ObjectId serieId, @PathVariable Integer numeroTemporada, @PathVariable Integer numeroEpisodio) {

        Episodio episodio = serieService.buscarEpisodio(serieId, numeroTemporada, numeroEpisodio);

        return ResponseEntity.ok(episodio);

    }
}
