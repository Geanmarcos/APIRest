package support;

import io.restassured.response.Response;
import objetcs.payloadRegister;


public class requestRegister {
    apihelper api;
    public static Response responseregister;
    payloadRegister register;

    public requestRegister() {
        api = new apihelper();
    }

    public void createRegisters(String correo, String contrasenia){
        String url = "https://reqres.in/api/register";
        //String register = "{\"email\": \""+correo+"\",\"password\": \""+contrasenia+"\"}";
        register = new payloadRegister(correo, contrasenia);
        responseregister = api.post(url,register);
    }
}
