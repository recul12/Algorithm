package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] c = s.toCharArray();
        Integer[] arr = new Integer[c.length];
        for (int i = 0; i < c.length; i++) {
            arr[i]=Character.getNumericValue(c[i]);
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
