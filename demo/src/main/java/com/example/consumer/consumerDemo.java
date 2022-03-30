package com.example.consumer;

import java.util.Arrays;
import java.util.List;

public class consumerDemo {

   /*
    * @Override
    * public void accept(Integer arg0) {
    * System.out.println(arg0);
    * 
    * }
    */

   public static void main(String[] args) {
      List<Integer> scores = Arrays.asList(4, 5, 6, 78, 89);

      /*
       * List<Integer> scores = new ArrayList<>();
       * scores.add(3);
       * scores.add(4);
       */
      scores.stream().forEach(t -> System.out.println(t));
   }

}
