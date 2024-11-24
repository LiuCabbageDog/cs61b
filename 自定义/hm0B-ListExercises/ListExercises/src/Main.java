import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int sum(List<Integer> n){
        int len = n.size();
        int sum = 0;
        if(len == 0){   // tese case1
            return 0;
        }
        else{
            for (int i: n){
                sum += i;
            }
        }
        return sum;
    }

    public static List<Integer> evens(List<Integer> n){
        int len = n.size();
        List<Integer> aim = new ArrayList<>();
        if(len == 0){   // tese case1
            return n;
        }
        else{
            for (int i: n){
                if(i % 2 == 0){
                    aim.add(i);
                }
            }
        }
        return aim;
    }

    public static List<Integer> common(List<Integer> n1, List<Integer> n2){
        int len1 = n1.size();
        int len2 = n2.size();
        List<Integer> aim = new ArrayList<>();

        if((len1 == 0) || (len2 == 0)){
            return aim;
        }
        else{
            for (int i1: n1){
                for (int i2: n2){
                    if (i1 == i2){
                        aim.add(i1);
                    }
                }
            }
        }
        return aim;
    }

    public static int count_char(List<String> n, char c){
        int len = n.size();
        int counter = 0;

        if(len == 0){
            return counter;
        }
        else{
            for(String i: n){ // get every string
                int slength = i.length(); // get how many char in the string
                for(int j = 0; j < slength; j++){ // iterate every char in the string
                    char temp  = i.charAt(j);
                    if(temp == c)
                    {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        // List the all lists for test
        List<Integer> test1 = new ArrayList<>();
        test1.add(3);
        test1.add(8);
        test1.add(5);
        test1.add(49);
        List<Integer> test2 = new ArrayList<>();
        List<Integer> test3 = new ArrayList<>();
        test3.add(5);
        test3.add(49);

        // test sum function
        int sum1 = sum(test1);
        int sum2 = sum(test2);
        int sum3 = sum(test3);
        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);

        // test evens function
        List<Integer> evenlist = new ArrayList<>();
        evenlist = evens(test1);
        for (int i : evenlist) {
            System.out.print(i);
        }
        System.out.println();

        evenlist = evens(test2);
        for (int i : evenlist) {
            System.out.print(i);
        }
        System.out.println();

        evenlist = evens(test3);
        for (int i : evenlist) {
            System.out.print(i);
        }
        System.out.println();

        //test common function
        List<Integer> commonlist = new ArrayList<>();
        commonlist = common(test1, test3);
        for (int i : commonlist) {
            System.out.print(i + " ");
        }
        System.out.println();

        //test count function
        List<String> special = new ArrayList<>();
        special.add("Hello,");
        special.add("World!");
        special.add("I");
        special.add("am");
        special.add("Liu Yize.");
        int times;
        times = count_char(special, 'l');
        System.out.println("l show " + times + " times");
    }
}