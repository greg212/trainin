package math;

/**
 * Created by gs on 2016-05-24.
 */
public class Math {

    // Math.signum

    public int addDigits(int num) {

        while(true) {
            int sum = 0;
            while(num>0) {
                sum  += num %10;
                num /=10;
            }
            num = sum;

            if(num<10) {
                break;
            }
        }

        return num;
    }
}
