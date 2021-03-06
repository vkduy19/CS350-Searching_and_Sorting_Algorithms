import java.util.Arrays;
import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        try (Scanner scanner_in = new Scanner(System.in)) {
            /*
             * Read size input
             */
            int input_size = Integer.parseInt(scanner_in.nextLine());

            /*
             * Read customer waiting times
             */
            int customer_waiting_times[] = new int[input_size];
            String elem_inputs[] = scanner_in.nextLine().split(" ");
            for (int i = 0; i < input_size; ++i) {
                customer_waiting_times[i] = Integer.parseInt(elem_inputs[i]);
            }

            /*
             * Sort customer waiting times
             * O(nlogn)
             */
            Arrays.sort(customer_waiting_times);

            /*
             * The customer is satisfied if
             * the elapsed time before him (sum of waiting times prior)
             * is less that his waiting limit
             */
            int elapsed = 0;
            int satisfy_customers = 0;
            for (int time : customer_waiting_times) {
                if (elapsed <= time) {
                    ++satisfy_customers;
                    elapsed += time;
                }
            }

            System.out.print(satisfy_customers);
        }
    }
}