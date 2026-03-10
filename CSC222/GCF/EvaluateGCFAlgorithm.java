import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class EvaluateGCFAlgorithm {

    // Adjust these if timings are too small/too slow on your machine
    private static final int WARMUP_ITERS = 30_000;
    private static final int TEST_ITERS = 300_000;

    // Prevents JVM from optimizing away the calls
    private static volatile int sink = 0;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Put the exact (a,b) pairs your assignment wants here
        int[][] tests = {
                {2, 6},
                {200, 1},
                {48, 180},
                {270, 192},
                {12345, 54321},
                {99991, 99989}
        };

        StringBuilder out = new StringBuilder();
        out.append(String.format("%-12s %-14s %-14s %-14s%n", "a,b", "gcf1 (ns)", "gcf2 (ns)", "gcf3 (ns)"));
        out.append("--------------------------------------------------------\n");

        for (int[] t : tests) {
            int a = t[0];
            int b = t[1];

            warmup(a, b);

            long t1 = timeGcf1(a, b);
            long t2 = timeGcf2(a, b);
            long t3 = timeGcf3(a, b);

            out.append(String.format("%-12s %-14d %-14d %-14d%n",
                    a + "," + b, t1, t2, t3));
        }

        System.out.print(out);

        // Save to results.txt in the same folder
        try (PrintWriter pw = new PrintWriter(new FileWriter("results.txt"))) {
            pw.print(out.toString());
        } catch (IOException e) {
            System.out.println("Could not write results.txt: " + e.getMessage());
        }
    }

    private static void warmup(int a, int b) {
        for (int i = 0; i < WARMUP_ITERS; i++) {
            sink ^= GCFAlgorithm.gcf1(a, b);
            sink ^= GCFAlgorithm.gcf2(a, b);
            sink ^= GCFAlgorithm.gcf3(a, b);
        }
    }

    private static long timeGcf1(int a, int b) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_ITERS; i++) {
            sink ^= GCFAlgorithm.gcf1(a, b);
        }
        return System.nanoTime() - start;
    }

    private static long timeGcf2(int a, int b) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_ITERS; i++) {
            sink ^= GCFAlgorithm.gcf2(a, b);
        }
        return System.nanoTime() - start;
    }

    private static long timeGcf3(int a, int b) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_ITERS; i++) {
            sink ^= GCFAlgorithm.gcf3(a, b);
        }
        return System.nanoTime() - start;
    }
}