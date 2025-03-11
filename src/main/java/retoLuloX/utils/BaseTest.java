package retoLuloX.utils;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    private static final String BASE_URL = "https://api.restful-api.dev";

    @BeforeAll
    public static void setupSerenity() {
        if (OnStage.theActorInTheSpotlight() == null) {
            System.out.println("Configurando Serenity Screenplay...");
            OnStage.setTheStage(new OnlineCast());
            OnStage.theActorCalled("Usuario de Prueba").whoCan(CallAnApi.at(BASE_URL));
            System.out.println("Actor configurado exitosamente.");
        }
    }
}