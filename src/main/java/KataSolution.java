import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class KataSolution {


    public static String expand(String expr) {
//(ax + b)^n
       // System.out.println(expr);
        int a, b, n;
        BigInteger c;

        StringBuilder sb = new StringBuilder();


        var index = Arrays.stream(expr.split("\\D"))
                .filter(w -> w.matches("^-?\\d+$"))
                .collect(Collectors.toList());

        var x = Arrays.stream(expr.split("[^a-z]"))
                .collect(Collectors.joining());
        if(index.size() == 3) {
            a = Integer.parseInt(index.get(0));

            b = Integer.parseInt(index.get(1));

            n = Integer.parseInt(index.get(2));

        } else {
            a = 1;
            b = Integer.parseInt(index.get(0));
            n = Integer.parseInt(index.get(1));
        }
        if (expr.indexOf("-") == 1) a = -a;
        if (expr.indexOf("-", 2) != -1) b = -b;

        //System.out.println("a = " + a + "; b = " + b + "; n = " + n);

        for (int i = n, j = 0; i >= 0; i--, j++) {

            c = getC(n, i, j, a, b);
            BigInteger cNext = getC(n, i-1, j+1, a, b);
//            sb.append(c);
            if(i >=0) {
                sb.append(c);
                sb.append(x);
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                    if(cNext.abs() == cNext) sb.append("+");
                }

            }
           // System.out.println(sb.toString());
        return sb.toString();
        }

    public static BigInteger getFactorial(int f) {
        if (f <= 1) {
            return BigInteger.valueOf(1);
        }
        else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }
    public static BigInteger getC (int n, int i, int j, int a, int b){ //(a+b)^n, (k = 0,...,n)
        return getFactorial(n).divide(getFactorial(j).multiply(getFactorial(n-j)))
                .multiply(BigInteger.valueOf(Math.round(Math.pow(a, i)) * Math.round(Math.pow(b,j))));
    }
}