public interface List61B<Item> {      //interface只考虑能做什么而不考虑怎么做

    //interface inheritance
    public void addLast(Item x) ;
    public Item getLast() ;
    public Item get(int i) ;
    public int size();
    public Item removeLast();
    //implementation inheritance
    default public void print(){
       for(int i = 0; i < size(); i++){
           System.out.print(get(i) + " ");
          }
       System.out.println();
    }




}