package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import support.requestCurso;

import java.util.List;
import java.util.Map;

public class ServicioCursoDefinition {

    requestCurso curso;
    private static String token;

    public ServicioCursoDefinition() {
        curso = new requestCurso();
    }

    @Given("debe estar logeado {string}")
    public void debeEstarLogeado(String correo) {
        curso.login(correo,"9alexander0");
    }

    @When("registrar datos del curso")
    public void registrarDatosDelCurso(DataTable dt) {
        ResponseBody body = requestCurso.responsecurso;
        JsonPath json = new JsonPath(body.asString());
        token = json.getString("token-session");
        //System.out.print(token);
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i=0; i < data.size(); i++){
           curso.registroCurso(data.get(i).get("titulo"),data.get(i).get("descripcion"),token);
        }
    }

    @Then("mostrar la respuesta")
    public void mostrarLaRespuesta() {
        ResponseBody body = requestCurso.responsecurso;
        System.out.print(body.asString());
    }

    @And("mostrar todos los cursos")
    public void mostrarTodosLosCursos() {
        curso.listarCursos(token);
        ResponseBody body = requestCurso.responsecurso;
        System.out.print(body.asString());
    }
}
