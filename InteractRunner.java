import java.util.Scanner;
public class InteractRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        try {
            Calculator calc = new Calculator();
            String UseResult = "y";
            String exit = "n";
            while (!exit.equals("y")) {
                System.out.println("Enter first argument: ");
                String a = reader.next();
                System.out.println("Enter operator: ");
                String b = reader.next();
                System.out.println("Enter second argument: ");
                String c = reader.next();
                calc.add(Double.valueOf(a),b,Double.valueOf(c));
                Double result = calc.getResult();
                System.out.println("Result: " + result + "Use result: y/n");
                String UseResult = reader.next();
                while (!UseResult.equals("n")) {
                    System.out.println("Enter operator: ");
                    String b = reader.next();
                    System.out.println("Enter second argument: ");
                    String c = reader.next();
                    calc.add(result,b,Double.valueOf(c));
                    result = calc.getResult*();
                    System.out.println("Result: " + result + "Use result: y/n");
                    String UseResult = reader.next();
                }
                calc.cleanResult();
                System.out.println("Exit: yes/no");
                exit = reader.next();

            }
        } finally {
            reader.close();
        }
    }
}