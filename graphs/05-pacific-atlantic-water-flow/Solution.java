private static class Coord {
    final int row, col;

    Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord)) return false;
        Coord other = (Coord) o;
        return row == other.row && col == other.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

private static class Frontier {
    final Queue<Coord> queue;
    final Set<Coord> visited;

    Frontier(Queue<Coord> queue, Set<Coord> visited) {
        this.queue = queue;
        this.visited = visited;
    }
}

public static List<List<Integer>> pacificAtlanticWaterFlow(List<List<Integer>> heights) {
    if (heights.size() == 0) return new ArrayList<>();
    int m = heights.size();
    int n = heights.get(0).size();

    Frontier pacific = buildFrontier(pacificEdgeCoords(m, n));
    Frontier atlantic = buildFrontier(atlanticEdgeCoords(m, n));

    bfs(heights, pacific.queue, pacific.visited, m, n);
    bfs(heights, atlantic.queue, atlantic.visited, m, n);

    Set<Coord> intersection = new HashSet<>(pacific.visited);
    intersection.retainAll(atlantic.visited);

    List<List<Integer>> answer = new ArrayList<>();
    for (var coord : intersection) {
        answer.add(List.of(coord.row, coord.col));
    }

    answer.sort(Comparator.<List<Integer>>comparingInt(c -> c.get(0)).thenComparing(c -> c.get(1)));
    return answer;
}

private static List<Coord> pacificEdgeCoords(int m, int n) {
    List<Coord> coords = new ArrayList<>();
    for (int j = 0; j < n; j++) coords.add(new Coord(0, j));
    for (int i = 1; i < m; i++) coords.add(new Coord(i, 0));
    return coords;
}

private static List<Coord> atlanticEdgeCoords(int m, int n) {
    List<Coord> coords = new ArrayList<>();
    for (int j = n - 1; j >= 0; j--) coords.add(new Coord(m - 1, j));
    for (int i = 0; i < m - 1; i++) coords.add(new Coord(i, n - 1));
    return coords;
}

private static Frontier buildFrontier(List<Coord> edgeCoords) {
    Queue<Coord> queue = new ArrayDeque<>(edgeCoords);
    Set<Coord> visited = new HashSet<>(edgeCoords);
    return new Frontier(queue, visited);
}

private static void bfs(List<List<Integer>> heights, Queue<Coord> queue, Set<Coord> visited, int m, int n) {
    int[] rowDelta = new int[] {-1, 0, 1, 0};
    int[] colDelta = new int[] {0, 1, 0, -1};

    while (!queue.isEmpty()) {
        var current = queue.poll();
        for (int i = 0; i < 4; i++) {
            Coord newCoord = new Coord(current.row + rowDelta[i], current.col + colDelta[i]);
            if (newCoord.row >= 0 && newCoord.row < m &&
                newCoord.col >= 0 && newCoord.col < n &&
                heights.get(newCoord.row).get(newCoord.col) >= heights.get(current.row).get(current.col) &&
                !visited.contains(newCoord)) {
                visited.add(newCoord);
                queue.add(newCoord);
            }
        }
    }
}
