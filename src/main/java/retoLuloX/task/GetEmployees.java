package retoLuloX.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import io.restassured.http.ContentType;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployees implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/employees")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .header("User-Agent", "Mozilla/5.0")  // Simula un navegador
                                .header("Cookie", "humans_21909=1")   // Usa la cookie que pide la API
                        )
        );
    }

    public static GetEmployees fromApi() {
        return instrumented(GetEmployees.class);
    }
}
