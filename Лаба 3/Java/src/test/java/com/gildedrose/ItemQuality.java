public class ItemQuality {
    private int value;

    public ItemQuality(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        if (value < 50) {
            value++;
        }
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }
}
