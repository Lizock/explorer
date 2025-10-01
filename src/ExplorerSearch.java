import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        boolean[][] visited = new boolean[island.length][island[0].length];

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == 0) {
                    return reachableArea(island, visited, i, j);
                }
            }
        }

        return 0;
    }

    private static int reachableArea(int[][] island, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= island.length || col >= island[0].length) return 0;

        if (island[row][col] == 2 || island[row][col] == 3 || visited[row][col]) return 0;

        visited[row][col] = true;

        int count = 1;

        int[][] moves = {
            {-1, 0}, //UP
            {1, 0}, //DOWN
            {0, 1}, //RIGHT
            {0, -1} //LEFT
        };
        
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            count += reachableArea(island, visited, newRow, newCol);
        }

        return count;
    }
}
