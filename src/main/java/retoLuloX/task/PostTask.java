package retoLuloX.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import retoLuloX.utils.FileWriterUtil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostTask implements Task {
    private final String body;
    private static final String RESPONSE_FILE = "post_response.txt";

    public PostTask(String body) {
        this.body = body;
    }

    public static PostTask withData(String body) {
        return instrumented(PostTask.class, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/objects").with(request -> request.body(body).contentType("application/json"))
        );

        String response = SerenityRest.lastResponse().asString();
        System.out.println("POST Response: " + response);

        FileWriterUtil.writeToFile(RESPONSE_FILE, response);
        System.out.println("Response saved to file: " + RESPONSE_FILE);
    }
}

