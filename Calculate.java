public class Calculate {
    public static void main(String[] args) {
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[2]);
        double result = 0;
        if (args[1].equals("+")){
            result=a+b;
        }
        if (args[1].equals("-")){
            result = a-b;
        }
        if (args[1].equals("*")){
            result = a*b;
        }
        if (args[1].equals("/")){
            result = a/b;
        }
        if (args[1].equals("^")){
            result = Math.pow(a, b);
        }

        System.out.println("Result: " + result);
    }
}