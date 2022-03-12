/*
Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764. The sum of the squared divisors is 2500 which is 50 * 50, a square!

Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square. 42 is such a number.

The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements, first the number whose squared divisors is a square and then the sum of the squared divisors.

#Examples:

list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]
 */
import java.util.ArrayList;
import java.util.stream.LongStream;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        ArrayList<String> strings = new ArrayList<>();
        LongStream.rangeClosed(m, n).forEach(current -> {
            long sum = LongStream.rangeClosed(1, current).filter(i -> current % i == 0).map(i -> i * i).sum();
            if (Math.sqrt(sum) % 1 == 0)
                strings.add(String.format("[%d, %d]", current, sum));
        });
        return String.valueOf(strings);
    }
}
