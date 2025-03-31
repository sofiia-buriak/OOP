import java.util.Arrays;
import java.util.List;

public class FamilyTaskManager {
    public static void main(String[] args) {
        var family = Arrays.asList(
                new FamilyMember("Тарас"),
                new FamilyMember("Марія"),
                new FamilyMember("Іван")
        );

        List<Task> tasks = Arrays.asList(
                new CleaningTask(),
                new CleaningTask()
        );

        new TaskDistributor(family).distribute(tasks);
    }
}
