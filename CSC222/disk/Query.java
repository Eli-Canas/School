package disk;

import java.util.ArrayList;
import java.util.Scanner;

public class Query {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int n = scnr.nextInt();
        ArrayList<ArrayList<Integer>> disk = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            int d = scnr.nextInt();
            ArrayList<Integer> line = new ArrayList<Integer>();

            for (int j = 0; j < d; j++) {
                line.add(scnr.nextInt());
            }

            disk.add(line);
        }

        int q = scnr.nextInt();

        for (int i = 0; i < q; i++) {
            int x = scnr.nextInt();
            int y = scnr.nextInt();

            if (x >= 1 && x <= disk.size() && y >= 1 && y <= disk.get(x - 1).size()) {
                System.out.println("Output:" +disk.get(x - 1).get(y - 1));
            } else {
                System.out.println("Output: ERROR!");
            }
        }
    }
}

