
import java.util.*;

public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];

        for (int i = 0; i < size; i++) {
            ar[i] = sc.nextInt();
        }
        First t1 = new First(ar, 0, size / 2);
        Second t2 = new Second(ar, size / 2, size);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int ans = t1.getSum() + t2.getSum();
        System.out.println(ans);

    }
}

class First extends Thread {
    private int[] arr;
    private int st, en, sm = 0;

    public First(int[] arr, int st, int en) {
        this.arr = arr;
        this.st = st;
        this.en = en;
    }

    public void run() {
        for (int i = st; i < en; i++) {
            sm += arr[i];
        }
    }

    public int getSum() {
        return sm;
    }
}

class Second extends Thread {
    private int[] arr;
    private int st, en, sm = 0;

    public Second(int[] arr, int st, int en) {
        this.arr = arr;
        this.st = st;
        this.en = en;
    }

    public void run() {
        for (int i = st; i < en; i++) {
            sm += arr[i];
        }
    }

    public int getSum() {
        return sm;
    }
}