import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        int t = Scan.nextInt();
        
        while (t-- > 0) {
            int F = Scan.nextInt();
            int U = Scan.nextInt();
            int K = Scan.nextInt();
            int M = Scan.nextInt();
            
            List<int[]> stations = new ArrayList<>();
            for (int i = 0; i < F; i++) {
                int A = Scan.nextInt();
                int P = Scan.nextInt();
                stations.add(new int[]{A, P});
            }
            Collections.sort(stations, (a, b) -> Integer.compare(a[0], b[0]));
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int totalCost = 0;
            int currentFuel = K;
            int currentPosition = 0;
            int stationIndex = 0;

            while (currentPosition < M) {
                // Add reachable stations to the priority queue
                while (stationIndex < F && stations.get(stationIndex)[0] <= currentPosition + currentFuel) {
                    pq.add(stations.get(stationIndex)[1]);
                    stationIndex++;
                }
                
                int maxReach = currentPosition + currentFuel;

                // Check if we can reach the destination
                if (maxReach >= M) {
                    break;
                }

                // If no station is reachable, we cannot proceed
                if (pq.isEmpty()) {
                    totalCost = -1;
                    break;
                }

                // Get the cheapest fuel price
                int cheapestPrice = pq.poll();
                
                // Calculate how much fuel is needed to reach the next station
                int fuelNeeded = Math.min(U - currentFuel, M - (currentPosition + currentFuel));
                
                // Update total cost and fuel
                totalCost += fuelNeeded * cheapestPrice;
                currentFuel += fuelNeeded;
                
                // Update current position after using the fuel
                currentPosition += currentFuel; // Update position with the distance traveled using currentFuel
                currentFuel = 0; // Reset current fuel after using it
            }
            
            // Output the total cost for the current test case
            System.out.println(totalCost);
        }
        Scan.close();
    }
}
