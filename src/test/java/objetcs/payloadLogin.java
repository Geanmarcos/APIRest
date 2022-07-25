package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadLogin {
    @JsonProperty(value = "email") private String correo;
    @JsonProperty(value = "password") private String contrasenia;

    public payloadLogin(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
}
