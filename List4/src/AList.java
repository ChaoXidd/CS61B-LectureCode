public class AList<Item> {
    private Item[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        items =(Item[]) new Object[100];
        size = 0;
    }

    /**
     * resize
     */
    private void resize(int capacity) {
        Item[] a =(Item[]) new Object[capacity];         //Java不允许泛型类型数组  Item[] a = new Item[capacity]错误
        System.arraycopy(items, 0, a, 0, size);
        items = a;

    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x) {
        if (size == items.length) {
            //resize(size + 1);
            resize(size * 2);//resize(size * RFACTOR)
        }
        items[size] = x;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    public Item getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i) {
        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public Item removeLast() {
        Item x = getLast();
        //items[size] = null;       unnecessary
        size--;
        return x;
    }
}