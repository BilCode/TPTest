package bil.learn.tutpoint;

import java.util.ArrayList;

/**
 * Created by Bilal on 028, 28-Aug-16.
 */
public class Testing {

    public static String test = "Testing";

    public String lastTwo(String str) {
        char[] strc = str.toCharArray();
        int l = str.length() - 1;
        char ld = strc[l];
        strc[l] = strc[l - 1];
        strc[l - 1] = ld;
        return String.valueOf(strc);
    }

    public int powerN(int base, int n) {
        if (n == 1) return base;
        int c = powerN(base, --n);
        return base * c;
    }

    public String makeOutWord(String out, String word) {
        int l = out.length() - 1;
        int lh = l / 2;
        return out.substring(0, lh) + word + out.substring(lh, l);
    }

    public String withoutX(String str) {
        String temp = str;
        if (str.startsWith("x")) {
            temp = str.substring(1, str.length());
        }
        if (str.endsWith("x")) {
            temp = str.substring(1, str.length());
        }
        return temp;
    }

    public int stringMatch(String a, String b) {
        int s = 0, e = 2;
        int count = 0;
        while ((e <= (a.length())) && (e <= (b.length()))) {
            if (a.substring(s, e).equals(b.substring(s, e))) {
                count++;
            }
            System.out.println(a.substring(s, e) + " -" + s + "- " + b.substring(s, e));
            e = e + 1;
            s = s + 1;
        }
        return count;
    }

    public void printTriangle() {
        //Using on loop
        int i = 0;
        String printer = "";
        while (i < 5) {
            i++;
            printer += " " + String.valueOf(i);
            System.out.println(printer);
        }
    }

    //Multiples of 3 and 5
    void sumOfNaturalNumbers(int limit) {
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            if (((i % 3) == 0) || ((i % 5) == 0)) {
                sum = sum + i;
                System.out.println("Added" + i);
            }
        }
        System.out.println(sum);
    }

    void findLongestPalindrome(String input) {
        if (isPalindrome(input)) {
            System.out.println(input);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            boolean found = false;
            int l = input.length() - (i + 1);
            int s = 0;
            int end = l;
            while ((end <= input.length()) && (l > 1)) {
                String temp = input.substring(s, end);
                if (isPalindrome(temp)) {
                    System.out.println(temp);
                    found = true;
                }
                s++;
                end = s + l;
            }
            if (found) return;
        }
    }

    boolean isPalindrome(String s) {
        if (s.equals((new StringBuilder(s).reverse().toString()))) {
            return true;
        }
        return false;
    }

    public static char firstNonRepeative(String input) {
        //input=input.toLowerCase();
        char[] inputchar = input.toCharArray();
        boolean found;
        for (int i = 0; i < input.length(); i++) {
            found = true;
            for (int k = (i + 1); k < input.length(); k++) {
                if (inputchar[i] == inputchar[k]) {
                    //System.out.println(inputchar[i]+ "Matched with "+inputchar[k]);
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println("First non repeated  " + inputchar[i]);
                return inputchar[i];
            }
        }
        return '-';
    }

    void findOccurrenceOfChar(String input, char a) {
        int count = 0;
        char[] inputChar = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (inputChar[i] == a) {
                count++;
            }
        }
        System.out.println("Occurance of " + a + " is " + count + " times");
    }

    void findWhiteFromBlackSquare(int[][] image) {
        ArrayList<WhiteBox> whiteBoxes = new ArrayList<WhiteBox>();
        WhiteBox opened = null;
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[0].length; x++) {
                System.out.print(image[y][x]);
                if (image[y][x] == 1) {
                    if (opened == null) {
                        opened = new WhiteBox();
                        opened.setStartx(x);
                        opened.setStarty(y);
                    } else {
                        opened.setEndx(x);
                        opened.setEndy(y);
                    }
                } else {
                    if (opened != null) {
                        if (y == 0)
                            whiteBoxes.add(opened);
                        else {
                            opened.updateInList(whiteBoxes);
                            if (((opened.getEndy() + 1) < (image.length - 1)) && image[opened.getEndy() + 1][opened.getEndx()] != 1) {
                                opened.setOpened(false);
                            }
                        }
                        opened = null;
                    }
                }
            }
            System.out.println("");
        }
        for (WhiteBox whiteBox : whiteBoxes) {
            System.out.println("(" + whiteBox.getStartx() + ", " + whiteBox.getStarty() + ")" + ": (" + whiteBox.getEndx() + " ," + whiteBox.getEndy() + ")");
        }
    }
}

class WhiteBox {
    private int startx, starty, endx, endy;
    private boolean isOpened = true;

    public int getStartx() {
        return startx;
    }

    public void setStartx(int startx) {
        this.startx = startx;
    }

    public int getStarty() {
        return starty;
    }

    public void setStarty(int starty) {
        this.starty = starty;
    }

    public int getEndx() {
        return endx;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public int getEndy() {
        return endy;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    void updateInList(ArrayList<WhiteBox> whiteBoxes) {
        boolean isUpdated = false;
        for (WhiteBox whiteBox : whiteBoxes) {
            if ((whiteBox.getStartx() == this.getStartx()) && (whiteBox.getEndx() == this.getEndx()) && whiteBox.isOpened()) {
                whiteBox.setEndy(this.getEndy());
                isUpdated = true;
                break;
            }
        }
        if (!isUpdated) {
            whiteBoxes.add(this);
        }
    }

}


