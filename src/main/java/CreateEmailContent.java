import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateEmailContent {
    public String makeHTMLContent() {
        Random random = new Random();
        Map<String, Integer> workout = new HashMap<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
        WorkoutCreator wc = new WorkoutCreator();
        wc.makeWorkout(workout, random);

        StringBuilder raw_content = new StringBuilder();
        String day_of_the_week = today.format(formatter);
        if(day_of_the_week != "Friday") {
            raw_content.append("<h1>Let's Workout!</h1>\r\n" +
                            "<p> Today is " + today.format(formatter) + " and it's time to get your health increase. You can say it's <b>SCHWARZENEGGER O'CLOCK</b>. \"<i>Come with me if you want to live</i>\". Hehe. </p>");
        }
        else {
            raw_content.append("<h1>Let's Workout!</h1>\r\n" +
                "<p> It's finally " + today.format(formatter) + ", but you know what time it is. It's time to get your health increase. You can even say it's <b>SCHWARZENEGGER O'CLOCK</b>. \"<i>Come with me if you want to live</i>\". Hehe. </p>");

        }
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
