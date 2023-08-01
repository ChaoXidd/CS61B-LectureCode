public class SLList {

    private static class IntNode {//static:静态的嵌套类类不能访问外部类的任何东西；节省内存
        public int item;
        public IntNode next;


        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;//哨兵节点，如果第一项存在则第一项为sentinel.next
    private int size;

    public SLList(){
        sentinel = new IntNode(63,null);
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(63,null);
        sentinel.next=new IntNode(x,null);
        size=1;
    }


    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size ++;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size++;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x,null);
    }

//private static int size(IntNode p){
//        if(p.next == null)
//        {
//            return 1;
//        }
//        return 1 + size(p.next);
//
//}

    public int size() {
//1.        IntNode p = first;
//        int n = 0;
//        while (p != null) {
//            n++;
//            p = p.next;
//        }
//        return n;
//2.        return size(first);
        return size;

    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);

        System.out.println(L.size());
    }

}
