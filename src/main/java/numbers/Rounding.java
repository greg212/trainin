package numbers;

/**
 * Created by U200320 on 2016-05-25.
 */
public class Rounding {

    //rounding an in

    //    http://stackoverflow.com/questions/7139382/java-rounding-up-to-an-int-using-math-ceil
    int ceil1(int a, int b) {

        int n = (a + b - 1) / b;
        return n;
    }

    //But a better option is to use the following, because then you are less likely to have overflow.

    int floor(int a, int b) {
        int n = (a - 1) / b + 1;
        return n;
    }
}
