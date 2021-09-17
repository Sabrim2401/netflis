package ar.com.ada.netflismongo.netflis.repos;

import org.springframework.stereotype.Repository;

import ar.com.ada.netflismongo.netflis.entities.Pelicula;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface PeliculaRepository extends MongoRepository <Pelicula,ObjectId> {
    
    
}