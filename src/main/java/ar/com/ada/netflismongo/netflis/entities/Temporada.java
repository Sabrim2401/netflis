package ar.com.ada.netflismongo.netflis.entities;

import java.util.*;

import lombok.*;

@Getter
@Setter
public class Temporada {

    private Integer numero;
    private String nombre; // Esto es el nombre de la temporada y no del capitulo
    private List<Episodio> episodios = new ArrayList<>();

    public Episodio buscarEpisodio(Integer numeroEpisodio) {

        for (Episodio episodio : this.episodios) {
            if (episodio.getNumeroEpisodio().equals(numeroEpisodio))
                return episodio;
        }
        return null;
    }


}
