import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        ArrayList<String> list = new ArrayList<String>();
        for(int d=0;d<a.length;d++){
            list.add(a[d]);
        }
        String str = "";
        while (!list.isEmpty()){
            int max = Integer.parseInt(list.get(0));
            for(int c=0;c<list.size();c++){
                int temp = Integer.parseInt(list.get(c));
                if(isGreaterThnaOrEqualTo(max,temp)){
                    max = temp;
                }
            }
            str += max;
            list.remove(String.valueOf(max));
        }
        return  str;
    }
    private static boolean isGreaterThnaOrEqualTo(int max, int temp){
        String str1 = String.valueOf(max) + String.valueOf(temp);
        String str2 = String.valueOf(temp) + String.valueOf(max);
        return Integer.parseInt(str1) <= Integer.parseInt(str2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
