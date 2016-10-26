import java.util.Arrays;

public class MyArrayList {

    private int[] arr = new int[10];
    private int size = 0;

    public void add(int i) {
        enlargeList();
        arr[size] = i;
        size++;
    }

    public void add(int i, int pos) {
        enlargeList();
        if (pos < 0 || pos >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, pos);
        System.arraycopy(arr, pos, temp, pos + 1, arr.length - pos - 1);

        temp[pos] = i;
        arr = temp;
        size++;
    }

    public void clear() {
        arr = new int[10];
        size = 0;
    }

    public int get(int pos) {
        return arr[pos];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return arr.length;
    }

    public MyArrayList clone() {
        MyArrayList retval = new MyArrayList();
        for (int i =0; i<size ;i ++) {
            retval.add(arr[i]);
        }
        return retval;
    }

    public String toString() {
        int[] temp = new int[size];
        System.arraycopy(arr, 0, temp, 0, size);
        return Arrays.toString(temp);
    }

    private void enlargeList() {
        if (size >= arr.length) {
            int[] temp = new int[size * 2];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }

    }

    private void delete(int pos){
        if(pos<0||pos>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, pos);
        System.arraycopy(arr, pos+1, temp, pos, arr.length-pos-1);
        arr = temp;
        size --;
        reduceList();
    }

    private void reduceList() {
        if (size <= (arr.length + 2) / 3) {
            int newSize = (int)(arr.length) / 2;
            int[] temp = new int[newSize];
            System.arraycopy(arr, 0, temp, 0, newSize);
            arr = temp;
        }

    }

    public static void main(String[] args) {
        MyArrayList al = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }

        System.out.println(al);
        System.out.println(al.size());

        al.add(5, 2);
        System.out.println(al);

        for (int i = 6; i > 0; i--) {
            al.delete(i);
            System.out.println(al.capacity()+"/"+al.size);
        }
        System.out.println(al);
        System.out.println(al.get(2));
        
        MyArrayList al2 = al.clone();
        al.clear();
        System.out.println(al);
        System.out.println(al2);
    }
}
