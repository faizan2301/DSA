package MyArrays;

public class MyArray {
    private final int[] items;
    private int currentIndex;

    public MyArray(int initialSize) {
        this.items = new int[initialSize];
        this.currentIndex = 0;
    }

    public void insert(int value) {
        this.items[currentIndex] = value;
        currentIndex++;
    }

    int getValue(int index) {
        return items[index];
    }

    public int indexOfValue(int value) {
        for (int i = 0; i < this.currentIndex; i++) {
            if (this.items[i] == value) {

                return i;

            }

        }
        return -1;
    }

    public void removeAt(int index) {
        if (index >= this.currentIndex) {
            throw new IndexOutOfBoundsException();

        }
        for (int i = index; i <= this.currentIndex - 2; i++) {
            this.items[i] = this.items[i + 1];

        }
        currentIndex--;
        this.items[currentIndex] = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < currentIndex; i++) {
            str.append(items[i]).append(", ");

        }
        str.append("\b").append("\b").append("]");
        return str.toString();

    }
}
