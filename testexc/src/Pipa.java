public class Pipa {

    public static void main(String[] args) throws Exception {
        sqrt(4);
        System.out.println(getCallerClassAndMethodName());

    }
    public static void sqrt(double x) throws Exception {
        System.out.println(Math.sqrt(x));
        System.out.println(getCallerClassAndMethodName());

    }
    public static String getCallerClassAndMethodName() throws RuntimeException{
        Throwable t = new Throwable();
        StackTraceElement[] ste = t.getStackTrace();
        if (ste.length<3){
            return null;
        } else {
            StackTraceElement element = ste[2];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            return className + "#" + methodName;
        }
    }
}
