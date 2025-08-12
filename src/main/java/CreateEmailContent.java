import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateEmailContent {
    public String makeHTMLContent() {
        Random random = new Random();
        Map<String, Integer> workout = new HashMap<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        WorkoutCreator wc = new WorkoutCreator();
        wc.makeWorkout(workout, random);

        StringBuilder raw_content = new StringBuilder();
        raw_content.append("<h1>Let's Workout!</h1>\r\n" +
                        "<p> Today is " + today.format(formatter) + " and it's time to get your health increase. You can say it's <b>SCHWARZENEGGER O'CLOCK</b>. \"<i>Come with me if you want to live</i>. Hehe. </p>");
        raw_content.append("\n\n<u>Workout</u>:");
        raw_content.append("<ul>");
        for(Map.Entry<String, Integer> entry : workout.entrySet()) {
            raw_content.append("<li>")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append(" repetitions</li>");
        }
        raw_content.append("</ul>");
        String content = raw_content.toString();
        return content;
    }
}
