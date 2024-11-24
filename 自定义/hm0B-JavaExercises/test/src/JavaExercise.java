import java.util.ArrayList;
import java.util.List;

public class JavaExercise{
    public static void makeDice(){
        int[] array = {1, 2, 3, 4, 5, 6};
        for (int i : array){
            System.out.print(i);
        }
        System.out.println();
    }

    public static String[] takeOrder(String name){
        String[] order1 = {"beyti", "pizza"};
        String[] order2 = {"sushi", "pasta"};
        String[] order3 = new String[2];
        if (name.equals("Ergun")){
            return order1;
        }
        else if (name.equals("Erik")){
            return order2;
        }
        else{
            return order3;
        }
    }

    public static int findMinMax(int[] numbers){
        int max, min;
        max = min = numbers[0];
        for (int i: numbers){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        return (max-min);
    }

    public static List<Integer> hailstone(int n){
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        while (n != 1){
            if (n % 2 == 0){
                n /= 2;
            }
            else{
                n *= 3;
                n += 1;
            }
            sequence.add(n);
        }
        return sequence;
    }


    public static void main(String[] args){
        makeDice();

        /** Below is the code of takeOrder */
        String[] order1 = takeOrder("Ergun");
        String[] order2 = takeOrder("Erik");
        String[] order3 = takeOrder("Tom");
        for (String i : order1){
            System.out.print(i + ", ");
        }
        System.out.println();

        for (String i : order2){
            System.out.print(i + ", ");
        }
        System.out.println();

        for (String i : order3){
            System.out.print(i + ", ");
        }
        System.out.println();

        /** Below is the code of findMinMax */
        int[] a = {3, 6, 9, 2, 7, 10,3, 5};
        int difference = findMinMax(a);
        System.out.println(difference);

        /** Below is the code of hailstone */
        List<Integer> lst = hailstone(45);
        for (int i: lst){
            System.out.print(i + " ");
        }
    }
}