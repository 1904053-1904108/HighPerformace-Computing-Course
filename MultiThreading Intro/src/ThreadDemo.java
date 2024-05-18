class Hi {
    public void show() {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

class Hello {
    public void show() {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        obj1.show();
        obj2.show();
    }
}