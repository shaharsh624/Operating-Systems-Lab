import java.util.Scanner;

public class Optimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		// Inputs
        System.out.print("Enter Page frame: ");
        int page = input.nextInt();

		System.out.print("Enter number of entries in queue: ");
        int entry = input.nextInt();

        int[] frame = new int[page];
        int[] entries = new int[entry];
        for (int i = 0; i < entry; i++) {
            System.out.print("Enter value of entry " + (i + 1) + ": ");
            entries[i] = input.nextInt();
        }
        for (int i = 0; i < page; i++) {
            frame[i] = -1;
        }
        int miss = page;
        for (int i = 0; i < page; i++) {
            frame[i] = entries[i];
        }
        for (int i = page; i < entry; i++) {
            int count = 0;
            for (int j = 0; j < page; j++) {
                if (frame[j] == entries[i]) {
                    break;
                }
                count++;
            }
            if (count == page) {
                int[] use = new int[page];
                for (int j = i; j < entry; j++) {
                    for (int k = 0; k < page; k++) {
                        if (frame[k] == entries[j]) {
                            use[k]++;
                        }
                    }
                }
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int j = 0; j < page; j++) {
                    if (use[j] < min) {
                        min = use[j];
                        minIndex = j;
                    }
                }
                frame[minIndex] = entries[i];
                miss++;
            }
        }
        System.out.println("Page Faults: " + miss);
        System.out.println("Page Hits: " + (entry -miss));
        input.close();
    }
}
