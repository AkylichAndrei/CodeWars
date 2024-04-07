//Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
// Any whitespace at the end of the line should also be stripped out.
public class Main {
    public static void main(String[] args) {
        StripComments ObjSC = new StripComments();
        System.out.println(ObjSC.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples",
               new String[] { "#", "!" } ));
    }
}
