package coursework;

import java.util.HashMap;

class Week6 {

    String[] leftSide;
    String rightSide;
    HashMap<String, String> mapper = new HashMap<String, String>();

    Week6(String[] leftSide, String rightSide) {

        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    boolean processor() {

        String checkval1 = String.join("", leftSide);
        String checkvalFinal = checkval1 + rightSide;
      

        String uniqueCheck = uniqueFinder(checkvalFinal, checkval1.charAt(checkval1.length() - 1));

        int leftSum = leftItterSum();

        String rightSum = "";

        for (int i = 0; i < rightSide.length(); i++) {
            rightSum += mapper.get("" + rightSide.charAt(i));
        }

      
        if (leftSum == Integer.parseInt(rightSum)) {
            return true;
        }

        return false;

    }

    int leftItterSum() {

        
        int unitsItter = 0;
        String[] units = new String[leftSide.length];
        int leftTotal = 0;

        

        for (int i = 0; i < leftSide.length; i++) {

            units[unitsItter] = "";

            for (int j = 0; j < leftSide[i].length(); j++) {

                
                units[unitsItter] += mapper.get("" + leftSide[i].charAt(j));

            }
            leftTotal += Integer.parseInt(units[unitsItter]);
            unitsItter++;

        }

       

        return leftTotal;
    }

    String uniqueFinder(String a, char leftend) {

        int len = 0;
        char[] passer = new char[a.length()];

        for (int i = 0; i < a.length(); i++) {
            boolean push = false;
            for (int j = 0; j < a.length(); j++) {
                if (i >= j) {
                    if (i == a.length() - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (a.charAt(i) == a.charAt(j)) {
                    push = false;
                    break;
                } else if (a.charAt(i) != a.charAt(j)) {
                    push = true;
                }
            }
            if (push) {
                passer[len] = a.charAt(i);
                push = false;
                len++;
            }
        }

        String combined = "";
        int itter = 0;

        String[] leftRightSum = new String[2];

        for (int i = 0; i < len; i++) {
            combined += passer[i];
            mapper.put("" + passer[i], "" + i);
           

        }

       

        return combined;
        

    }

    public static void main(String[] args) {

        String[] leftInput = { "THIS", "IS", "TOO" };

        System.out.println(new Week6(leftInput, "FUNNY").processor());
    }

}

