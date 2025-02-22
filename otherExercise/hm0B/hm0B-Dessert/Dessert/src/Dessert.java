public class Dessert {
    public int flavor;
    public int price;
    static int numDessert = 0;

    public Dessert(int a, int b){
        flavor = a;
        price = b;
        numDessert++;
    }

    public void printDessert(){
        System.out.println("flavor: " + flavor + "price: " + price + "number: " + numDessert);
    }
}
