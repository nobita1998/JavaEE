package designPattern;
/*
* 单例模式：饿汉式，懒汉式
*
* */
public class singleTon {
    public static void main(String[] args) {
        Person p = Person.getInstance();

    }


}
// 饿汉式
//class Person{
//    private Person() {}
//    private static Person instance = new Person();
//
//    public static Person getInstance() {
//        return instance;
//    }
//}

// 懒汉式,double check
class Person{
    private Person() {}
    private static Person instance = null;

    public static Person getInstance() {
        if (instance == null){
            synchronized (Person.class) {
                if (instance == null){
                    instance = new Person();
                }
            }
        }
        return instance;
    }
}
