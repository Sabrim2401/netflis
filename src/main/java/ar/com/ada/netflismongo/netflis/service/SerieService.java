package ar.com.ada.netflismongo.netflis.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import ar.com.ada.netflismongo.netflis.entities.Episodio;
import ar.com.ada.netflismongo.netflis.entities.Pelicula;
import ar.com.ada.netflismongo.netflis.entities.Serie;
import ar.com.ada.netflismongo.netflis.repos.PeliculaRepository;
import ar.com.ada.netflismongo.netflis.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository repo;

    @Autowired
    MongoTemplate mongoTemplate;

    public void crearSerie(Serie serie) {
        repo.save(serie);
    }

    public List<Serie> traerSeries() {
        return repo.findAll();
    }

    public Episodio buscarEpisodio(ObjectId serieId, Integer numeroTemporada, Integer numeroEpisodio) {

        MatchOperation matchSeriesStage = Aggregation.match(new Criteria("_id").is(serieId));
        ProjectionOperation projecttemporadastage = Aggregation.project("temporadas");
        UnwindOperation unwindtemporadastage = Aggregation.unwind("temporadas");
        MatchOperation matchtemporadastage = Aggregation.match(new Criteria("temporadas.numero").is(numeroTemporada));
        ReplaceRootOperation replaceRoottemporadastage = Aggregation.replaceRoot("temporadas");
        UnwindOperation unwindEpisodeStage = Aggregation.unwind("episodes");
        ReplaceRootOperation replaceRootEpisodeStage = Aggregation.replaceRoot("episodes");
        MatchOperation matchEpisodeStage = Aggregation.match(new Criteria("number").is(numeroEpisodio));

        Aggregation aggregation = Aggregation.newAggregation(matchSeriesStage, projecttemporadastage,
                unwindtemporadastage, matchtemporadastage, replaceRoottemporadastage, unwindEpisodeStage,
                replaceRootEpisodeStage, matchEpisodeStage);
        AggregationResults<Episodio> result = mongoTemplate.aggregate(aggregation, "Series", Episodio.class);
        Episodio episodio = result.getUniqueMappedResult();
        return episodio;

    }
}