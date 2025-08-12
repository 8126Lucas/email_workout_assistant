import java.util.*;

public class WorkoutCreator {
    public static final String[] EXERCISES = {"Push-Ups", "Sit-Ups", "Squats", "Reverse Crunches", "Russian Twist",
                            "Donkey Kicks (Left)", "Donkey Kicks (Right)", "Jumping Squats", "Burpees",
                            "One Leg Push-Ups", "Fire Hydrant (Left)", "Fire Hydrant (Right)", "Calf Raises",
                            "Triceps Dips", "Diamond Push-Ups", "Up And Down Plank", "Reverse Push-Ups",
                            "Plank Taps", "Jumping Jacks", "Push-Up And Rotation"};

    public void makeWorkout(Map<String, Integer> workout, Random random) {
        List<String> list_exercises = new ArrayList<>(Arrays.asList(EXERCISES));
        Collections.shuffle(list_exercises, random);
        for(int i = 0; i < 8; i++) {
            String random_exercise = list_exercises.get(i);
            Integer random_reps =  random.nextInt(50 - 30 - 1) + 30;
            workout.put(random_exercise, random_reps);
        }
    }
}
