import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases
    @Test
    public void testReachableArea_someUnreachable2() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,3,3},
            {1,1,1,2,3,0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_someUnreachable3() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,2,3},
            {3,1,2,2,1,2},
            {1,1,1,2,1,0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }

    @Test
    public void testReachableArea_noStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,2,3},
            {3,1,2,2,1,2},
            {1,1,1,2,1,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(0, actual);
    }
}
