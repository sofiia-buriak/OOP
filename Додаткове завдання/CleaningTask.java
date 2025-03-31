public class CleaningTask implements Task {
    public void complete(FamilyMember executor) {
        System.out.println(executor + " прибирає");
    }
}
