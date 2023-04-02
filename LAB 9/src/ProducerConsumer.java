import java.util.*;

public class ProducerConsumer {
    static Scanner sc = new Scanner(System.in);
    static int mutex = 1;
    static int pos = -1;
    static int n = 3;
    static String item;
    static Stack<String> newBuffer = new Stack<String>();
    
    public static int wait(int s) {
        while (s != 1) ;
        return (--s);
    }

    public static int signal(int s) {
        return (++s);
    }

    public static void producer () {
        mutex = wait(mutex);
        pos = signal(pos);
        if (pos < n) {
            System.out.print("Enter Item to Produce: ");
            String item = sc.next();
            System.out.println("Produced item '" + item + "'");
            newBuffer.push(item);
        }
        mutex = signal(mutex);
    }

    public static void consumer () {
        mutex = wait(mutex);
        pos--;
        if (pos >= -1) {
            item = newBuffer.pop();
            System.out.println("Consumed item '" + item + "'");
        }
        mutex = signal(mutex);
    }

    public static void display () {
        if (newBuffer.size() == 0) {
            System.out.print("Buffer -> EMPTY");
        }
        else {
            System.out.print("Buffer -> ");
            for (String i : newBuffer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter Buffer size : ");
        n = sc.nextInt();

        System.out.println("\n1. Producer\n2. Consumer\n3. Display Buffer\n4. Exit");
        boolean loop = true;
        while (loop) {
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case (1) -> {
                    if (mutex == 1 && (pos+1) < n) {
                        producer();
                    } else {
                        System.out.println("Buffer is full, There's no space to Produce!");
                    }
                }
                case (2) -> {
                    if (mutex == 1 && pos >= 0) {
                        consumer();
                    } else {
                        System.out.println("Buffer is empty, There's nothing to Consume!");
                    }
                }
                case (3) -> display();
                case (4) -> {
                    System.out.println("\nThank You!");
                    loop = false;
                }
                default -> System.out.println("Please Enter correct Choice");
            }
        }
    }
}
