package ar.com.ada.netflismongo.netflis.entities;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Getter
@Setter
@Document(collection = "Series")
public class Serie extends Contenido {

    private List<Temporada> temporadas;

}
