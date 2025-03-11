package retoLuloX.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import retoLuloX.task.PostTask;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiPostSteps {

    @When("el usuario crea un nuevo objeto con los siguientes datos:")
    public void createNewObject(String body) {
        theActorCalled("Usuario de Prueba").attemptsTo(PostTask.withData(body));
    }

    @Then("la respuesta del POST debe contener el campo {string} con valor {string}")
    public void validatePostResponse(String key, String value) {
        theActorCalled("Usuario de Prueba").should(
                seeThatResponse("El body del POST contiene el valor esperado",
                        response -> response.body(key, equalTo(value)))
        );
    }
}
