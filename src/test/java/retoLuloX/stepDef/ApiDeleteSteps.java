package retoLuloX.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;
import retoLuloX.task.DeleteTask;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ApiDeleteSteps {

    @When("el usuario elimina el objeto creado")
    public void deleteCreatedObject() {
        theActorCalled("Usuario de Prueba").attemptsTo(DeleteTask.deleteCreatedObject());
    }

    @Then("el body debe contener el campo mensaje con valor {string}")
    public void validateDeleteResponse(String value) {
        String response = SerenityRest.lastResponse().getBody().asString();
        try {
            JSONObject jsonResponse = new JSONObject(response);

            String message = jsonResponse.getString("message");
            System.out.println("Extracted Message: " + message);

            Assert.assertTrue("El mensaje de respuesta no es válido", message.contains(value));

        } catch (Exception e) {
            throw new AssertionError("Error parsing DELETE response: " + e.getMessage());
        }
    }
}
