/*
Write Number in Expanded Form

You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

NOTE: All numbers will be whole numbers greater than 0.

If you liked this kata, check out part 2!!

 */
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static String expandedForm(int num)
    {
        return IntStream
                .iterate(1, k -> num / k > 0, k -> k * 10)
                .map(k -> (num % (k*10) / k ) * k)
                .filter(x -> x > 0)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(integer -> integer.toString())
                .collect(Collectors.joining(" + "));
    }
}