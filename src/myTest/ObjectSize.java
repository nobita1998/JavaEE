package myTest;

import java.util.HashMap;
import java.util.Random;

public class ObjectSize {
    public static void main(String[] args) {
        Integer integer = 16;
        HashMap<Integer, Integer> map = new HashMap<>();
        Random rdm = new Random();
        for (int i = 0; i < 66; i++) {
            map.put(i, rdm.nextInt(100));
        }
//        System.out.printf("", map);
        System.out.println(map.size());
    }
}
