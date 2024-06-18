package MyArrays;

import java.util.Arrays;

public class MyArray {
    private int[] items;
    private int currentIndex;

    public MyArray() {
        this.items = new int[10];

    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void insert(int value) {
        if (currentIndex == items.length) {
            int[] temp = new int[items.length * 2];
            System.arraycopy(items, 0, temp, 0, currentIndex);
//            for(int i=0;i<currentIndex;i++){
//                temp[i]=items[i];
//            }
            items = temp;
        }
        this.items[currentIndex] = value;
        currentIndex++;
    }

    int getValue(int index) {
        return items[index];
    }

    int getLength() {
        return items.length;
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

    public int max() {
        int result = this.items[0];
        for (int i = 1; i < currentIndex; i++) {
            if (items[i] > result) {
                result = items[i];
            }
        }
        return result;
    }

    public int min() {
        int result = this.items[0];
        for (int i = 1; i < currentIndex; i++) {
            if (items[i] < result) {
                result = items[i];
            }
        }
        return result;
    }

    public void reverse() {
        int i = 0;
        int j = currentIndex - 1;
        while (i < j) {
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
            i++;
            j--;
        }
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
