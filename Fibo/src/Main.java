/**
 * Created by saim on 23/05/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(fibo(47));
    }
    private static int fibo(int i){
        if(i == 0){
            return 0;
        }
        if (i == 1){
            return 1;
        }
        return fibo(i - 1) + fibo(i - 2);
    }
}
