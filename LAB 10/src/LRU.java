import java.util.Arrays;
import java.util.Scanner;

public class LRU {
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
        Arrays.fill(frame, -1);
        int miss = page;
        int[] used = new int[page];
        for (int i = 0; i < page; i++) {
            frame[i] = entries[i];
        }
        for (int i = page; i < entry; i++) {
            int count = 0;
            for (int j = 0; j < page; j++) {
                if (entries[i] == frame[j]) {
                    for (int k = 0; k < page; k++) {
                        used[k]++;
                    }
                    used[j] = 0;
                    break;
                }
                count++;
            }
            if (count == page) {
                for (int j = 0; j < page; j++) {
                    used[j]++;
                }
                int max = Integer.MIN_VALUE;
                int maxIndex = 0;
                for (int j = 0; j < page; j++) {
                    if (used[j] > max) {
                        max = used[j];
                        maxIndex = j;
                    }
                }
                used[maxIndex] = 0;
                frame[maxIndex] = entries[i];
                miss++;
            }
        }
        System.out.println("Page Faults: " + miss);
        System.out.println("Page Hits: " + (entry -miss));
        input.close();
    }
}