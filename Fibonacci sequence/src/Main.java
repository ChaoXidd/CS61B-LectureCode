public class Main {
    public static int fib(int n, int k, int f0, int f1){
        if(n == 0){
            return f0;
        }
        return fib(n-1, 0, f1, f0 + f1);
    }
    public static void main(String[] args) {
        int i = fib(7, 0, 0,1);
        System.out.println(i);
    }
}