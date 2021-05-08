import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class stores (in an arraylist) and prints the Fibonacci sequence (the desired length of which can be entered in the algorithm).
 *
 * The maximum length that can be entered is 93 beyond which Java starts printing negative integers. This is due to the fact that Java can store integer values
 * only less than 10 Quintillion and the Fibonacci sequence crosses that order of magnitude (which can be stored by java) beyond the 93rd value.
 *
 * This algorithm uses a FIFO queue in its iteration.
 *
 */

public class Fibonacci {

    public static void main(String[] args){

        ArrayList<String> FibonacciSeq = new ArrayList<String>();
        FibonacciSeq.add("0");
        FibonacciSeq.add("1");

        long thirdEntIter;

        Queue<String> twoFibEntries = new LinkedList<>();
        twoFibEntries.add("0");
        twoFibEntries.add("1");

        //The desired length of the sequence can be entered here
        int FibNosLength = 25;

        for(int x = 0; x < (FibNosLength-2); x++) {

            String[] qtoStrarr = new String[2];
            String[] queueStrArr = twoFibEntries.toArray(qtoStrarr);

            long[] queueLongArr = new long[queueStrArr.length];

            for (int k = 0; k < queueStrArr.length; k++) {
                queueLongArr[k] = Long.parseLong(queueStrArr[k]);
            }

            long sum = 0;

            for (int i = 0; i < queueLongArr.length; i++) {
                sum = sum + queueLongArr[i];
            }

            thirdEntIter = sum;

            twoFibEntries.remove();

            twoFibEntries.add(Long.toString(sum));

            FibonacciSeq.add(Long.toString(sum));

        }

        System.out.println("The first "+ FibNosLength+" Fibonacci nos are:");

        for(int i=0; i < FibonacciSeq.size(); i++){
            System.out.println(FibonacciSeq.get(i));
        }

    }

}
