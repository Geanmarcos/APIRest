package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadCurso {
    @JsonProperty(value = "title") private String titulo;
    @JsonProperty(value = "descripcion") private String descripcion;

    public payloadCurso(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
