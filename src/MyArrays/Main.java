package MyArrays;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(15);
        myArray.insert(1);
        myArray.insert(2);
        myArray.insert(3);
        myArray.insert(4);
        myArray.insert(5);
       myArray.removeAt(0);
        System.out.println(myArray);
    }

}
