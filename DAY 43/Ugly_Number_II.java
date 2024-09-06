class Solution {

    // private static int[] UGLY_NUMBERS = new int[1691];
    // static {
    //     int number = 1;
    //     int n2 = 1;
    //     int n3 = 1;
    //     int n5 = 1;
    //     for (int n = 1; n < 1691; n++) {
    //         UGLY_NUMBERS[n] = number;
    //         int min2 = UGLY_NUMBERS[n2] * 2;
    //         int min3 = UGLY_NUMBERS[n3] * 3;
    //         int min5 = UGLY_NUMBERS[n5] * 5;
    //         int min = min2 < min3 ? min2 : min3;
    //         if (min5 < min) {
    //             min = min5;
    //         }
    //         if (min == min2) {
    //             n2++;
    //         }
    //         if (min == min3) {
    //             n3++;
    //         }
    //         if (min == min5) {
    //             n5++;
    //         }
    //         number = min;
    //     }
    // }
    private static Ugly ugly = new Ugly();

    public int nthUglyNumber(int n) {
        return ugly.number(n);
        // return UGLY_NUMBERS[n];
    }

    // 1
    // 2, min(1*2, 1*3, 1*5)
    // 3, min(2*2, 1*3, 1*5)
    // 4, min(3*2, 2*3, 1*5)
    // 5, min(3*2, 2*3, 1*5)
    // 6, min(3*2, 2*3, 2*5)
    // 8, min(5*2, 3*3, 2*5)
    // 9, min(5*2, 3*3, 2*5)
    // 10, min(5*2, 4*3, 2*5)
    // 12, min(6*2, 4*3, 3*5)
    // 14, min(7*2, 4*3, 3*5)
    // 


}

class Ugly {
    private int[] numbers = new int[1691];
    public Ugly() {
        numbers[1] = 1;
        int n2 = 1;
        int n3 = 1;
        int n5 = 1;
        for (int n = 2; n < 1691; n++) {
            int min2 = numbers[n2] * 2;
            int min3 = numbers[n3] * 3;
            int min5 = numbers[n5] * 5;
            int min = min2 < min3 ? min2 : min3;
            if (min5 < min) {
                min = min5;
            }
            if (min == min2) {
                n2++;
            }
            if (min == min3) {
                n3++;
            }
            if (min == min5) {
                n5++;
            }
            numbers[n] = min;
        }
    }
    public int number(int n) {
        return numbers[n];
    }
}