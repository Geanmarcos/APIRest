package support;

import io.restassured.response.Response;
import objetcs.payloadCurso;
import objetcs.payloadLogin;

public class requestCurso {
    apihelper api;
    public static Response responsecurso;
    payloadLogin login;
    payloadCurso curso;


    public requestCurso() {
        api = new apihelper();
    }

    public void login(String correo, String contrasenia){
        login = new payloadLogin(correo, contrasenia);
        String url = "http://alp-backend.test/api/login";
        responsecurso = api.post(url,login);
    }

    public void registroCurso(String titulo, String descripcion, String token){
        curso = new payloadCurso(titulo, descripcion);
        String url = "http://alp-backend.test/api/courses/register";
        responsecurso = api.postHeader(url,curso,token);
    }

    public void listarCursos(String token){
        String url = "http://alp-backend.test/api/courses";
        responsecurso = api.getHeader(url,token);
    }
}
