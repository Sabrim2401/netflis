package ar.com.ada.netflismongo.netflis.entities;

import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;

import lombok.*;

@Getter
@Setter
public class Contenido {

    @JsonSerialize(using = ToStringSerializer.class) // convertidor a String ya que _id es objectId
    private ObjectId _id;

    private String nombre;

    private GeneroEnum genero;

    private IdiomaEnum idiomaOrigen;

    private int añoLanzamiento;

    public List<Actor> actores = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public IdiomaEnum getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public void setIdiomaOrigen(IdiomaEnum idiomaOrigen) {
        this.idiomaOrigen = idiomaOrigen;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public enum GeneroEnum {
        TERROR(1), ROMANTICA(2), COMEDIA(3), FANTASIA(4), ANIMADA(5);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private GeneroEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static GeneroEnum parse(Integer id) {
            GeneroEnum status = null; // Default
            for (GeneroEnum item : GeneroEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    public enum IdiomaEnum {
        ESPANOL(1), INGLES(2), ITALIANO(3), FRANCES(4), RUSO(5);

        private final Integer value;

        // NOTE: Enum constructor tiene que estar en privado
        private IdiomaEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static IdiomaEnum parse(Integer id) {
            IdiomaEnum status = null; // Default
            for (IdiomaEnum item : IdiomaEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

}