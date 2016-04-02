public class Calculate {
    public static void main(String[] args) {
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[2]);
        double result = 0;
        switch (args[0]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                case "^":
                    result = Math.pow(a, b);
                    break;
        }
        System.out.println("Result: " + result);
        }
        }

