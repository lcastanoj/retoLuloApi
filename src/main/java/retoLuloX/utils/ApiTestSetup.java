package retoLuloX.utils;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;

public class ApiTestSetup {

    private static final String BASE_URL = "https://dummy.restapiexample.com/api/v1";

    public static void setup() {
        OnStage.setTheStage(new OnlineCast());

        Actor user = OnStage.theActorCalled("User");
        user.can(CallAnApi.at(BASE_URL));
    }
}

