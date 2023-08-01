/** SList with additional operation printLostItems() which prints all items
 * that have ever been deleted. */
public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList(){    //在Java，任何时候写构造函数，该构造函数必须从一个超类的构造函数开始，如果你不做，Java自动执行
        super();
        deletedItems = new SLList<Item>();

    }
    public VengefulSLList(Item x){
        super(x);//有参数时必须指定超类构造函数
        deletedItems = new SLList<Item>();

    }
    @Override
      public Item removeLast(){
//        Node back = getLastNode();    private子类也无法使用
//        if (back == sentinel) {
//            return null;
//        }
//
//        size = size - 1;
//        Node p = sentinel;
//
//        while (p.next != back) {
//            p = p.next;
//        }
//        p.next = null;
//        return back.item;
        Item x = super.removeLast();    //使用父类中的函数
        deletedItems.addLast(x);
        return x;
    }


    public void printLostItems(){
        deletedItems.print();
    }

    public static void main(String[] args) {

		VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>();
		vs1.addLast(1);
		vs1.addLast(5);
		vs1.addLast(10);
		vs1.addLast(13);
		// vs1 is now: [1, 5, 10, 13]

		vs1.removeLast();
		vs1.removeLast();
		// After deletion, vs1 is: [1, 5]

		// Should print out the numbers of the fallen, namely 10 and 13.
		System.out.print("The fallen are: ");
		vs1.printLostItems();
    }
} 