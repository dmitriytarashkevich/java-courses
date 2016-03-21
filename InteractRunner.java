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
                Double a = reader.nextDouble();
                System.out.println("Enter operator: ");
                String b = reader.next();
                System.out.println("Enter second argument: ");
                Double c = reader.nextDouble();
                switch (b) {
                    case "+":
                        calc.add(a, c);
                        break;
                    case "-":
                        calc.dif(a, c);
                        break;
                    case "*":
                        calc.mltp(a, c);
                        break;
                    case "/":
                        calc.dev(a, c);
                        break;
                    case "^":
                        calc.inv(a, c);
                        break;
                }
                Double result = calc.getResult();
                System.out.println("Result: " + result);
                System.out.println("Use result: y/n");
                UseResult = reader.next();
                while (!UseResult.equals("n")) {
                    System.out.println("Enter operator: ");
                    b = reader.next();
                    System.out.println("Enter second argument: ");
                    c = reader.nextDouble();
                    switch (b) {
                        case "+":
                            calc.add(result, c);
                            break;
                        case "-":
                            calc.dif(result, c);
                            break;
                        case "*":
                            calc.mltp(result, c);
                            break;
                        case "/":
                            calc.dev(result, c);
                            break;
                        case "^":
                            calc.inv(result, c);
                            break;
                    }
                    result = calc.getResult();
                    System.out.println("Result: " + result);
                    System.out.println("Use result: y/n");
                    UseResult = reader.next();
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