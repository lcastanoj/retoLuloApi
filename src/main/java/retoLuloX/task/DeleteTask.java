package retoLuloX.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.json.JSONObject;
import retoLuloX.utils.FileReaderUtil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteTask implements Task {

    private static final String RESPONSE_FILE = "post_response.txt";

    public static DeleteTask deleteCreatedObject() {
        return instrumented(DeleteTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String responseContent = FileReaderUtil.readFile(RESPONSE_FILE);

        String objectId = null;
        try {
            JSONObject jsonResponse = new JSONObject(responseContent);
            if (jsonResponse.has("id")) {
                objectId = jsonResponse.getString("id");
                System.out.println("Extracted ID from file: " + objectId);
            } else {
                throw new IllegalStateException("No ID found in the response file.");
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error parsing JSON from file: " + e.getMessage());
        }

        if (objectId == null || objectId.isEmpty()) {
            throw new IllegalStateException("The ID of the object to delete was not found.");
        }

        actor.attemptsTo(
                Delete.from("/objects/" + objectId)
                        .with(request -> request.header("Content-Type", "application/json"))
        );
    }
}
