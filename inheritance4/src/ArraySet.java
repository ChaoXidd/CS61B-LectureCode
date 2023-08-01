import java.util.*;

public class ArraySet<T> implements Iterable<T> {   //有了implements Iterable<T>后加强for循环才有效
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (x.equals(items[i])) {   //不能使用x == items[i]:    如字符串集合， 只会比较集合内与外两字符串的内存框地址
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can't add null to an ArraySet!");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
    /*
       public Interface Iterator<T>{
           boolean hasNext();
           T next();
       }
     */


    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItems = items[wizPos];
            wizPos++;
            return returnItems;
        }
    }

    /*
    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");          //StringBuilder更快
        for (int i = 0; i < size - 1; i++) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }
    */

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for(T x : this){
            listOfItems.add(x.toString());
        }
       return "{" + String.join(", ", listOfItems) + "}";
    }


    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff){
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for(Glerp x : stuff){
            returnSet.add(x);
        }
        return returnSet;
    }



    @Override
    public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if (other == null) {
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size != this.size) {
            return false;
        }
        for (T items : this) {
            if (!o.contains(items)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Set<Integer> javaset = new HashSet<>();
        javaset.add(5);
        javaset.add(23);
        javaset.add(42);
//        for(int i : javaset){
//            System.out.println(i);
//        }
        Iterator<Integer> seer = javaset.iterator();
        while (seer.hasNext()) {
            int i = seer.next();          //seer.next()   1.返回当前的值  2.移动到下一项
            //System.out.println(i);
        }


        ArraySet<String> s = new ArraySet<>();
        //s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        //System.out.println(s.contains("horse"));
        //System.out.println(s.size());

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

//        Iterator<Integer> aseer = aset.iterator();
//        while(aseer.hasNext()){
//            int i = aseer.next();
//            System.out.println(i);
//        }


        for (int i : aset) {                              //这段代码相当于上面代码的简写，但它不知道这里存在一个可用的iterator方法
            System.out.println(i);                      //它需要的是确保ArraySet类有一个iterator方法(implements Iterable<T>),之后就可以做调用
        }

        /*
        public Interface implements Iterable<T>{
            Iterator<T> iterator();
        }
         */

        System.out.println(aset);

        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset2.equals(aset));

        ArraySet<String> asetOfString = of("hi", "I'm", "here");
        System.out.println(asetOfString);



    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */


}