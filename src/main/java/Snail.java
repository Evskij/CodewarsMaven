import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Snail Sort

Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]

For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */
public class Snail {

    public static int[] snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        List<Integer> cash = new ArrayList<>();
        int n = array.length;
        int[] res = new int[n * n];
        if (array[0].length == 0) return new int[0];
        int z = n;
        int x = 0;
        int y = 0;
        while (n > 0){
            for (int i = 0; i < n; i++) {
                result.add(array[x][y + i]);
            }
            x++;
            n--;
            for (int i = 0; i < n; i++) {
                result.add(array[i+x][n + y]);
            }
            for (int i = 0; i < n; i++) {
                cash.add(array[z - x][i + y]);
            }
            Collections.reverse(cash);
            result.addAll(cash);
            cash.clear();
            n--;
            for (int i = 0; i < n; i++) {
                cash.add(array[x + i][y]);
            }
            Collections.reverse(cash);
            result.addAll(cash);
            cash.clear();
            y++;
        }

        for (int i=0; i < res.length; i++)
        {
            res[i] = result.get(i).intValue();
        }
        return res;
    }
}