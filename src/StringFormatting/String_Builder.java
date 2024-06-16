package StringFormatting;

public class String_Builder {
    public static void main(String[] args) {
        String helloWorld = "Hello" + "World";
        helloWorld.concat(" and Goodbye");

        //StringBuffer helloWorldBuilder = "Hello" + "World";   // We can not do this ways with StringBuilder
        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + "World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorld);  // return Hello World
        printInformation(helloWorldBuilder); // return Hello World and Goodbye

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(17));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart32);

        StringBuilder helloWorldBuilderPlus = new StringBuilder("Hello" + " World");
        helloWorldBuilderPlus.append(" and Goodbye");
        helloWorldBuilderPlus.deleteCharAt(16).insert(16,"g");
        System.out.println(helloWorldBuilderPlus);

        helloWorldBuilderPlus.replace(16,17,"G");
        System.out.println(helloWorldBuilderPlus);

        helloWorldBuilderPlus.reverse().setLength(7);
        System.out.println(helloWorldBuilderPlus);
    }

    public static void  printInformation(String string){
        System.out.println("String = "+ string);
        System.out.println("length = "+ string.length());
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("StringBuilder = " + builder);
        System.out.println("length = "+ builder.length());
        System.out.println("capacity = "+ builder.capacity());
    }
}
