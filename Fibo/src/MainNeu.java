import java.util.HashMap;
import java.util.Map;

/**
 * Created by saim on 23/05/16.
 */
public class MainNeu {

        public static Map<Long, Long> map = new HashMap<>();

        public static void main(String[] args) {
            System.out.println(fibo(47));
            System.out.println(fibo(5020));
            System.out.println(fibo(8));
        }

        private static long fibo(long n){
            if(n == 0){
                return 0;
            }
            if (n == 1){
                return 1;
            }

            Long value = map.get(n);
            if(value != null)
                return value;

            value = fibo(n - 1) + fibo(n - 2);
            map.put(n, value);
            return value;

        }
}
