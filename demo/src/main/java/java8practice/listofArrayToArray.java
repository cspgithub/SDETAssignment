package java8practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listofArrayToArray {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(3546);
        list.add(123);
        list.add(35343546);


        int[] a = list.stream().mapToInt(i -> i).toArray();
        int total = a.length;
       // System.out.println(total);
        Arrays.sort(a);
        int highest2nd = a[total-2];
        System.out.println(highest2nd);

    }

}
