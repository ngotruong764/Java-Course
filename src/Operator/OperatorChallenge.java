package Operator;

public class OperatorChallenge {
    public static void main(String[] args) {
        double var1 = 20d;
        double var2 = 80d;

        double cal = var1 + var2 * 100;
        System.out.println("My value = "+ cal);
        double remainder = cal % 40d;

        boolean isZero = remainder == 0d ? true : false;
        System.out.println(isZero);

        if(!isZero){
            System.out.println("Got some remainder");
        }
    }
}
