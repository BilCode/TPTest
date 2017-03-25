package bil.learn.tutpoint;

public class Tests {

    public static void main(String[] args) {
        System.out.println("Test");
        Testing testing = new Testing();
        /*System.out.println(testing. lastTwo("Coding"));
        System.out.println(testing. withoutX("xCoding"));
		System.out.println(testing. stringMatch("xxcaazz", "xxbaaz"));
		OOPTest objoop = new OOPTest();
		System.out.println(objoop.b);
		Childoop objcoop = new Childoop();
		System.out.println(objcoop.a);
		objoop.pTest();
		Childoop.sTest();*/
        //testing.printTriangle();
        //testing.sumOfNaturalNumbers(1000);
        //testing.findLongestPalindrome("rajarThisismadam");
        //testing.findOccurrenceOfChar("This is very good",'h');

        /*String test= testing.test;
        System.out.println(test);
        System.out.println( Testing.test);*/

        int[][] image = new int[][]{
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0}
        };
        testing.findWhiteFromBlackSquare(image);

        /*int a =9;
        long b =0;
        b=a;
        char c='8';
        c=(char)a;
        System.out.println("Converted "+c);*/
    }
}
