package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestRegister;

import java.util.List;
import java.util.Map;

public class ServicioRegistroDefinition {

    requestRegister register;

    public ServicioRegistroDefinition() {
        register = new requestRegister();
    }

    @Given("Que no exista un registro")
    public void queNoExistaUnRegistro() {
    }


    @When("Realizar la creacion de registros")
    public void realizarLaCreacionDeRegistros(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i=0; i < data.size(); i++){
            register.createRegisters(data.get(i).get("correo"),data.get(i).get("contrasenia"));
            validarCodigoDeRespuesta(data.get(i).get("codigo"));
            mostrarLosDatosDelRegistro();
        }
    }

    @And("Validar codigo de respuesta {string}")
    public void validarCodigoDeRespuesta(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), requestRegister.responseregister.getStatusCode());
    }

    @Then("Mostrar los datos del registro")
    public void mostrarLosDatosDelRegistro() {
        ResponseBody body = requestRegister.responseregister;
        System.out.print(body.asString());
    }
}
