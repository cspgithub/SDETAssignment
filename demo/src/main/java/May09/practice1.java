package May09;

import java.util.ArrayList;

import java.util.List;

public class practice1 {

    public static void main(String[] args) {

        //final int[] array = { 5, 6, 8, 0, 34325, 324 };
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(4);
        listOfNumbers.add(53464);
        listOfNumbers.add(3434);
        listOfNumbers.add(90904);
        System.out.println("list After sorting" + usingSort(listOfNumbers));

        System.out.println("largerst number in array is :--" + largestInArray(convertListToArray(listOfNumbers)));

    }

    public static int largestInArray(int[] array) {

        int max = array[0];
        int sizeOfarray = array.length;
        for (int i = 0; i < sizeOfarray; i++) {
            if (array[i] > max) {
                max = array[i];
            }

        }
        return max;

    }

    public static List<Integer> usingSort(List<Integer> listOfNumbers) {

        listOfNumbers.sort((a, b) -> a.compareTo(b));

        return listOfNumbers;

    }

    public static int[] convertListToArray(List<Integer> list) {

        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;

    }

}
