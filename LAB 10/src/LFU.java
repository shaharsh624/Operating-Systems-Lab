import java.util.*;

public class LFU {

    public static int pageFaults(int n, int c, int[] pages) {
        int count = 0;
        List<Integer> v = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int i;
        for (i = 0; i <= n - 1; i++) {
            int index = v.indexOf(pages[i]);
            if (index == -1) {
                if (v.size() == c) {
                    mp.put(v.get(0), mp.get(v.get(0))-1);
                    v.remove(0);
                }
                v.add(pages[i]);
                mp.put(pages[i], mp.getOrDefault(pages[i], 0)+1);
                count++;
            } else {
                mp.put(pages[i], mp.get(pages[i])+1);
                v.remove(index);
                v.add(pages[i]);
            }
            int k = v.size() - 2;
            while (k > -1 && mp.get(v.get(k)) > mp.get(v.get(k + 1))) {
                Collections.swap(v, k, k+1);
                k--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		// Inputs
        System.out.print("Enter Page frame: ");
        int c = input.nextInt();

		System.out.print("Enter number of entries in queue: ");
        int n = input.nextInt();
        
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of entry " + (i + 1) + ": ");
            pages[i] = input.nextInt();
        }

        System.out.println("Page Faults = " + pageFaults(n, c, pages));
        System.out.println("Page Hits = " + (n - pageFaults(n, c, pages)));

        input.close();
    }
}
