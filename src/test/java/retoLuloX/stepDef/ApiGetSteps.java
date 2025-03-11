package retoLuloX.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import net.serenitybdd.screenplay.actors.OnStage;
import retoLuloX.task.GetEmployees;
import retoLuloX.utils.ApiTestSetup;

public class ApiGetSteps {

    @Given("que el usuario tiene acceso a la API")
    public void setBaseUrl() {
        ApiTestSetup.setup();  // Configurar Serenity y el actor
    }

    @When("el usuario realiza una peticion GET a empleados")
    public void getEmployees() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetEmployees.fromApi());
    }

    @Then("la respuesta debe tener codigo {int}")
    public void validateStatusCode(int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("El código de respuesta es correcto",
                        response -> response.statusCode(statusCode))
        );
    }

    @Then("el body debe contener el campo {string} con valor {string}")
    public void validateResponseBody(String key, String value) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("El body contiene el valor esperado",
                        response -> response.body(key, equalTo(value)))
        );
    }
}
