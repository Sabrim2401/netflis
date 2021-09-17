package ar.com.ada.netflismongo.netflis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.netflismongo.netflis.entities.Pelicula;
import ar.com.ada.netflismongo.netflis.repos.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository repo;

    public void crearPelicula(Pelicula pelicula) {
        repo.save(pelicula);
    }

}