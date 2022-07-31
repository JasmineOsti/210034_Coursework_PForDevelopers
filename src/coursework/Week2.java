package coursework;

class Week2 {

    int LenArr;
    int[] a;

    Week2(int LenArr, int[] a) {

        this.LenArr = LenArr;
        
        int len = 0;
        int[] joiner = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            boolean push = false;
            for (int j = 0; j < a.length; j++) {
                if (i >= j) {
                    if (i == a.length - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (a[i] == a[j]) {
                    push = false;
                    break;
                } else if (a[i] != a[j]) {
                    push = true;
                }
            }
            if (push) {
                joiner[len] = a[i];
                push = false;
                len++;
            }
        }

        int[] originaljoiner = new int[len];

        for (int i = 0; i < len; i++) {
            originaljoiner[i] = joiner[i];
           
        }

        this.a = originaljoiner;

    }

    void Findresult() {

        

        int[][] outputResult = findPrime(a);
        int[] mainResult = outputResult[0];
        int mainloop = outputResult[1][0];
        
        if (mainloop == LenArr) {

            for (int i = 0; i < mainloop; i++) {
                System.out.println(mainResult[i]);
            }
        } else {

            int[] more = moreSearch(mainResult, mainloop);
           
            for (int i = 0; i < LenArr; i++) {
                if (i >= mainloop) {
                    int num = i - mainloop;
                    System.out.println(more[num]);
                } else {
                    System.out.println(mainResult[i]);
                }

            }
        }

    }

    int[] moreSearch(int[] primes, int mainloop) {

        int[] mores = new int[LenArr];
        int moresin = 0;
        boolean skip = false;
        for (int i = 0; i < a.length; i++) {
            for (int ext = 0; ext < primes.length; ext++) {
                if (a[i] == primes[ext]) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                skip = false;
                continue;
            }

            boolean push = true;

            for (int j = 0; j < mainloop; j++) {

                if (primes[j] == 1) {
                    continue;
                } else {
                    
                    float checkval = (float) a[i] / (float) primes[j];
                    if (checkval == Math.floorDiv(a[i], primes[j])) {
                        push = false;
                    }
                }
            }

            if (push) {
                mores[moresin] = a[i];
                moresin++;
            }

        }

        return mores;

    }

    int[][] findPrime(int[] arr) {
      

        int[] ourPrimeElements = new int[LenArr];
        int mainloop = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                continue;
            } else if (arr[i] == 1) {
                ourPrimeElements[mainloop] = 1;
                mainloop++;

            } else if (arr[i] == 2) {
                ourPrimeElements[mainloop] = 2;
                mainloop++;
            } else if (arr[i] == 3) {
                ourPrimeElements[mainloop] = 3;
                mainloop++;
            }

            else {

                boolean prime = true;
                
                int divideLimit = Math.floorDiv(arr[i], 2);
                for (int j = 2; j <= divideLimit; j++) {

                    float check = (float) a[i] / j;
                   

                    if (check == Math.floorDiv(a[i], j)) {

                        prime = false;

                    }
                }

                if (prime == true) {

                    ourPrimeElements[mainloop] = a[i];
                    mainloop++;
                }

            }

        }

        int[][] returner = { ourPrimeElements, { mainloop } };

        return returner;

    }


    public static void main(String[] args) {

        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 };

        Week2 sub = new Week2(3, input);
        sub.Findresult();
    }

}