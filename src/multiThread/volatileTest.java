package multiThread;

import java.util.ArrayList;
import java.util.List;

public class volatileTest {

    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("插入字符串，此时list的长度为" + list.size());
                try {
                    Thread.sleep(500);  // 因为睡眠时容易出InterruptedException异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    notice = true;
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while(true){
                if (notice){
                    System.out.println("B开始工作");
                    break;
                }
            }
        });

        threadB.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();

    }
}
