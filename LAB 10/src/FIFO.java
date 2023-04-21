import java.util.Scanner;

public class FIFO {
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
		int miss = 0;
		int next = 0;
		for (int i = 0; i < entry; i++) {
			int count = 0;
			for (int j = 0; j < page; j++) {
				if (frame[j] == entries[i]) {
					break;
				}
				count++;
			}
			if (count == page) {
				miss++;
				frame[next] = entries[i];
				next = (next + 1) % page;
			}
		}
        System.out.println("Page Faults: " + miss);
        System.out.println("Page Hits: " + (entry -miss));
		input.close();
	}
}