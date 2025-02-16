package lec3_lists1;

public class List1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /*
        // 1 rd
        IntList returnlist = new IntList(L.first, null);
        // 2 rd
        returnlist.rest = new IntList(L.rest.first, null);
        // 3 rd
        returnlist.rest.rest = new IntList(L.rest.rest.first, null);

        temp1 = returnlist;
        temp1 = temp1.rest;
        temp2 = L;
        temp2 = temp2.rest;

        temp1 = new intlist(temp2.first, null)
        */
        // initialize the first node
        IntList returnlist = new IntList(L.first + x, null);
        IntList tempOutput = returnlist;
        // start with 2nd node
        IntList tempInput = L.rest;
        // if next node in example list is not null, copy value
        while(tempInput != null){
            tempOutput.rest = new IntList(tempInput.first + x, null);
            tempOutput = tempOutput.rest;
            tempInput = tempInput.rest;
        }

        return returnlist;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList temp = L;
        temp.first += x;
        // if list have next node
        while(temp.rest != null){
            // move to next node
            temp = temp.rest;
            // change value in next node
            temp.first += x;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        //System.out.println(L.get(1));

        /** Test your answers by uncommenting. Or copy and paste the
        code for incrList and dincrList into IntList.java and
        run it in the visualizer. */

        IntList test1 = incrList(L, 3);
        IntList test2 = dincrList(L, 3);
        /*
        for(int i = 0; i < test1.size(); i++){
            System.out.println(i + "th is " + test1.first);
            test1 = test1.rest;
        }

        for(int i = 0; i < test2.size(); i++){
            System.out.println(i + "th is " + test2.first);
            test2 = test2.rest;
        }

         */

        // Print test1 (incrList result)
        System.out.println("incrList result:");
        IntList temp1 = test1;
        for (int i = 0; temp1 != null; i++) {
            System.out.println(i + "th is " + temp1.first);
            temp1 = temp1.rest;
        }

        // Print test2 (dincrList result)
        System.out.println("dincrList result:");
        IntList temp2 = test2;
        for (int i = 0; temp2 != null; i++) {
            System.out.println(i + "th is " + temp2.first);
            temp2 = temp2.rest;
        }
    }
}