import java.util.List;
import java.util.Random;

public class TaskDistributor {
    private final List<FamilyMember> members;
    private final Random random = new Random();

    public TaskDistributor(List<FamilyMember> members) {
        this.members = members;
    }

    public void distribute(List<Task> tasks) {
        tasks.forEach(task -> {
            int index = random.nextInt(members.size());
            FamilyMember executor = members.get(index);
            task.complete(executor);
        });
    }
}
