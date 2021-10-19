package com.zysaaa.zysaaa20210218;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DSF {
    public static void main(String[] args) throws FileNotFoundException, NoSuchFieldException, InterruptedException {


        int i = 4;


        while (i -- > 0) {

            int nextInt = new Random().nextInt(10000);
            Thread.sleep(nextInt);

            System.out.println(nextInt % 2 == 0);


        }




//        Class<?> clazz = (Class<?>) ((ParameterizedType)String.class.getDeclaredField("users")
//                .getGenericType()).getActualTypeArguments()[0];
//
//
//
//        ArrayList<String> list = new ArrayList<>();

//        // 在类的外部这样获取
//        Type type = ((ParameterizedType)list.getClass().getGenericType()).getActualTypeArguments()[0];
//        System.out.println(type);
//        Type t = list.getClass().getGenericSuperclass();
//        if (t instanceof ParameterizedType) {
//            System.out.println(t);
//            // output: cn.think.in.java.clazz.loader.generics.Base<cn.think.in.java.clazz.loader.generics.DataClass>
//            for (Type type : ((ParameterizedType) t).getActualTypeArguments()) {
//                System.out.println(type);
//                //output: class cn.think.in.java.clazz.loader.generics.DataClass
//            }
//        }
//        // Custom input array
//        // It contains 8 elements as follows
//        int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
//
//        // Sort subarray from index 1 to 4, i.e.,
//        // only sort subarray {7, 6, 45, 21} and
//        // keep other elements as it is.
//        Arrays.sort(arr, 1, 5);
//
//        // Printing the updated array which is
//        // sorted after 2 index inclusive till 5th index
//        System.out.printf("Modified arr[] : %s",
//                Arrays.toString(arr));
//
////        Map<String, Integer> sort = storeText();
////        System.out.println("State: \t\t  Population:");
////        for (Map.Entry<String, Integer> key : sort.entrySet())
////        {
////            System.out.printf("%-20s %d%n", key.getKey(), key.getValue());
////        }
    }

    public static Map<String, Integer> storeText() throws FileNotFoundException
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        FileInputStream file = new FileInputStream("/Users/caoweibo/Downloads/Assignment1CData.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
        {
            String s = "";
            try {
                s = input.nextLine();
                String[] trim = s.split(",");
                String[] trim2 = trim[1].split("   ");
                String state = trim2[0].replace(" ", "");
                Integer totalPopulation = Integer.parseInt(trim2[1]);

                map.put(state, map.getOrDefault(state, map.getOrDefault(state, 0) + totalPopulation));
            } catch (Exception e) {
                System.out.println(s);
            }
        }
        return map;
    }

}
