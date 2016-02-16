public class Main {


    private static Minireknare minireknare = new Minireknare();

    public static void main(String args[]) {
        try {
            while (true) {
                minireknare.minireknare();
            }
        }catch (NumberFormatException e){
            System.out.println("bye bye");
        }
    }
}
