package ar.com.ada.netflismongo.netflis.entities;
import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

    
    private int duracion;

    private Director director;

    private boolean filmadaEnIMAX;

}
