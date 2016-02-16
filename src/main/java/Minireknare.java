import javax.swing.*;
import java.util.Scanner;

public class Minireknare {

    private static Scanner scanner = new Scanner(System.in);

    public void minireknare() {

        String input1;
        String input2;
        double parsedInput1 = 0;
        double parsedInput2 = 0;

        String raknesatt;

        try {
            do {
                input1 = JOptionPane.showInputDialog("Skriv in ett tal:");
                checkAvsluta(input1);
            } while (!inputValidating(input1));
            parsedInput1 = inputParser(input1);


            do {
                raknesatt = JOptionPane.showInputDialog("Ange räknesätt");
                checkAvsluta(raknesatt);
            } while (!checkValidRaknesatt(raknesatt));


            do {
                input2 = JOptionPane.showInputDialog("Skriv in de andra talet");
                checkAvsluta(input2);
            } while (!inputValidating(input2));
            parsedInput2 = inputParser(input2);

            JOptionPane.showMessageDialog(null, "Resultat: " + getSum(raknesatt, parsedInput1, parsedInput2));
        }catch (NullPointerException e){
            //do nothing
        }
    }
    public double addition(double x, double y) {
        return x + y;
    }

    public double pi() {
        return 3.1415;
    }

    public double multiplikation(double x, double y) {
        return x * y;
    }

    public double division(double x, double y) {
        return x / y;
    }

    public double kvadratroten(double x) {
        return Math.sqrt(x);
    }

    public double subtraktion(double x, double y) {
        return x - y;
    }

    public double getSum(String raknesatt, double input1, double input2){
        if (raknesatt.equals("*")) {
            return multiplikation(input1, input2);
        } else if (raknesatt.equals("-")) {
            return subtraktion(input1, input2);
        } else if (raknesatt.equals("+")) {
            return addition(input1, input2);
        } else if (raknesatt.equals("/")) {
            return division(input1, input2);
        }
        return 0;
    }

    public boolean checkValidRaknesatt(String raknesatt) {
        String[] validRaknesatt ={"*", "-", "+", "/"};

        boolean contains = false;

        for (String name : validRaknesatt) {
            if (name.equals(raknesatt)){
                contains = true;
                break;
            }
        }
        return contains;
    }

    public void avsluta(){
        System.exit(0);
    }

    public boolean checkAvsluta(String input){

        try {
            if (input.equals("x") || input.equals("avsluta")) {
                avsluta();
                return true;
            }
        }catch (NullPointerException e){
            System.exit(0);
        }
        return false;
    }

    public double inputParser(String input){
        double parsedInput = 0;
        try {
            parsedInput = Double.parseDouble(input);

        } catch (NumberFormatException e){
            return parsedInput;
        }
        return parsedInput;
    }

    public boolean inputValidating(String input){
        double parsedInput;
        try {
            parsedInput = Double.parseDouble(input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}