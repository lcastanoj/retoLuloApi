package retoLuloX.stepDef.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hooks {

    private static final String BASE_URL = "https://api.restful-api.dev";

    @Before(order = 0)
    public void setUp() {
        try {
            OnStage.setTheStage(new OnlineCast());
            OnStage.theActorCalled("Usuario de Prueba").whoCan(CallAnApi.at(BASE_URL));

        } catch (Exception e) {
            System.out.println("Error en Hook: " + e.getMessage());
        }
    }
}


