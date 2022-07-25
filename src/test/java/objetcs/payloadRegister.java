package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadRegister {

    @JsonProperty(value = "email") private String correo;

    @JsonProperty(value = "password") private String contrasenia;

    public payloadRegister(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
}
