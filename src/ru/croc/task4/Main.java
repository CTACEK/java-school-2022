package ru.croc.task4;

public class Main {
    public static void main(String[] args) {
        //В текстах программ на Java могут использоваться
        // многострочные (/* ... */) и однострочные (// ...) комментарии.
        // Реализовать метод, принимающий на вход строковую переменную - исходный текст программы на Java,
        // вырезающий из этой строки все комментарии и возвращающий результат в виде строки.

        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued..."; // test data
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    static String removeJavaComments(String source){
        while (source.contains("//") || (source.contains("/*") && source.contains("*/"))){
            source = source.replaceAll("//.*", "");
            source = source.replaceAll("/\\*[\\S\\s]+?\\*/", "");
        }
        return source;
    }
}
