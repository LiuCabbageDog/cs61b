import java.util.*;

public class Main {
    public static Map<Character, Integer> letterToNum(){
        Map<Character, Integer> map = new HashMap<>();
        char c = 'a';
        int unicode = c;
        int  n = 1;
        map.put(c, n);

        for (int i = 0; i < 25; i++){
            unicode += 1;
            n += 1;
            map.put((char)unicode, n);
        }
        return map;
    }

    public static Map<Integer, Integer> squares(List<Integer> lst){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: lst){
            map.put(i, i*i);
        }
        return map;
    }

    public static Map<String, Integer> countWords(List<String> words){
        Map<String, Integer> map = new HashMap<>();
        for (String s :words){
            //if s not show before, add new couple
            //if s has shown before, add counter
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
            else{
                map.put(s, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        // Test Case for lettertoNum
        Map<Character, Integer> map = letterToNum();
        for(char c: map.keySet()){
            System.out.println(c + ": " + map.get(c));
        }

        // Test Case for Squares
        List<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(5);
        lst.add(12);
        lst.add(7);
        Map<Integer, Integer> map1 = squares(lst);
        for(int i: map1.keySet()){
            System.out.println(i + ": " + map1.get(i));
        }

        // Test Case for countWords
        List<String> lst1 = new ArrayList<>();
        lst1.add("ha");
        lst1.add("ha");
        lst1.add("I");
        lst1.add("am");
        lst1.add("ha");
        lst1.add("king");
        Map<String, Integer> map2 = countWords(lst1);
        for(String s: map2.keySet()){
            System.out.println(s + ": " + map2.get(s));
        }





    }
}