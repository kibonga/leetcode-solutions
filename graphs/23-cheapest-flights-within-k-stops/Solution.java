class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] prevDistance = Arrays.copyOf(distance, distance.length);

            for (var flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (prevDistance[from] != Integer.MAX_VALUE && prevDistance[from] + price < distance[to]) {
                    distance[to] = prevDistance[from] + price;
                }
            }
        }

        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1;
    }
}
