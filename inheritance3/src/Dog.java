import java.util.Comparator;

public class Dog implements Comparable<Dog> {  //Comparable:Java内置
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }
    /*  
       有了Comparator后这段代码可以去掉
       Comparable：比较自己和另外一个对象； Comparator：比较另外两个对象。Comparable和Comparator相对独立
    */

    public void bark() {
        System.out.println(name + " says: bark");
    }
    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }
    //SizeComparator...
    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }
}