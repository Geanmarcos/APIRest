package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestResource;
import support.requestUser;

import java.util.List;
import java.util.Map;

public class ServicioRecursosDefinition {

    requestResource resource;

    public ServicioRecursosDefinition() {
        resource = new requestResource();
    }

    @Given("listar recursos")
    public void listarRecursos() {
        resource.getResources();
    }

    @When("mostrar el listado de recursos")
    public void mostrarElListadoDeRecursos() {
        ResponseBody body = requestResource.responseresource;
        System.out.print(body.asString());
    }

    @And("validar codigo de respuesta recurso {string}")
    public void validarCodigoDeRespuestaRecurso(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo),requestResource.responseresource.getStatusCode());
    }

    @Then("validar numero de registros recursos")
    public void validarNumeroDeRegistrosRecursos() {
        ResponseBody body = requestResource.responseresource;
        JsonPath json = new JsonPath(body.asString());
        List<String> listado = json.with(body.asString()).get("data");
        int cantidad = json.getInt("per_page");
        Assert.assertEquals(cantidad,listado.size());
    }


    @Given("listar recurso con id {string}")
    public void listarRecursoConId(String id) {
        resource.getResource(id);
    }


    @When("mostrar informacion del recurso")
    public void mostrarInformacionDelRecurso() {
        mostrarElListadoDeRecursos();
    }

    @Then("validar informacion de la consulta recurso")
    public void validarInformacionDeLaConsultaRecurso(DataTable resource) {
        ResponseBody body = requestResource.responseresource;
        JsonPath json = new JsonPath(body.asString()).setRootPath("data");
        //variable .map es cabecera y valor
        List<Map<String, String>> data = resource.asMaps(String.class, String.class);
        for (int i=0; i < data.size(); i++){
            Assert.assertEquals(data.get(i).get("nombre"), json.getString("name"));
            Assert.assertEquals(data.get(i).get("anio"), json.getString("year"));
            Assert.assertEquals(data.get(i).get("color"), json.getString("color"));
        }
    }
}
