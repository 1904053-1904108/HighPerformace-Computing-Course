
//package OOPSinJAVA;
//Author - Tutul Dhar -1904108

import java.util.*;

public class arraymax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];

        for (int i = 0; i < size; i++) {
            ar[i] = sc.nextInt();
        }
        FirstThread t1 = new FirstThread(ar, 0, size / 2);
        SecondThread t2 = new SecondThread(ar, size / 2, size);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int ans = t1.getMax();
        ans = Math.max(ans, t2.getMax());
        System.out.println(ans);

    }
}

class FirstThread extends Thread {
    private int[] arr;
    private int st, en, mx = 0;

    public FirstThread(int[] arr, int st, int en) {
        this.arr = arr;
        this.st = st;
        this.en = en;
    }

    public void run() {
        for (int i = st; i < en; i++) {
            mx = Math.max(mx, arr[i]);
        }
    }

    public int getMax() {
        return mx;
    }
}

class SecondThread extends Thread {
    private int[] arr;
    private int st, en, mx = 0;

    public SecondThread(int[] arr, int st, int en) {
        this.arr = arr;
        this.st = st;
        this.en = en;
    }

    public void run() {
        for (int i = st; i < en; i++) {
            mx = Math.max(mx, arr[i]);
        }
    }

    public int getMax() {
        return mx;
    }
}