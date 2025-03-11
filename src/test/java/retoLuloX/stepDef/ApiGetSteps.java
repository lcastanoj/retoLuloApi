package retoLuloX.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItem;

import net.serenitybdd.rest.SerenityRest;
import retoLuloX.utils.*;
import retoLuloX.task.GetTask;

public class ApiGetSteps {

    @When("el usuario realiza una peticion GET")
    public void getObjects() {
        theActorCalled("Usuario de Prueba").attemptsTo(GetTask.fromApi());

        String responseBody = SerenityRest.lastResponse().getBody().asString();
        FileUtil.saveToFile(responseBody, "response.txt");
    }

    @Then("la respuesta debe tener codigo {int}")
    public void validateStatusCode(int statusCode) {
        theActorCalled("Usuario de Prueba").should(
                seeThatResponse("El código de respuesta es correcto",
                        response -> response.statusCode(statusCode))
        );
    }

    @Then("la respuesta del GET debe contener el campo {string} con valor {string}")
    public void validateGetResponse(String key, String value) {
        theActorInTheSpotlight().should(
                seeThatResponse("El body del GET contiene el valor esperado",
                        response -> response.body(key, hasItem(value)))
        );
    }
}
