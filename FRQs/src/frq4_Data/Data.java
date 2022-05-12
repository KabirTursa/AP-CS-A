package frq4_Data;

/**
 * Class Data is part of Question 4 from the FRQs in the
 * 2022 AP Computer Science A exam.
 * Problem definition from page 14 in:
 * https://apcentral.collegeboard.org/pdf/ap22-frq-computer-science-a.pdf
 */
public class Data {

    public static final int MAX = 13; /* value provided as example */
    private int[][] grid;
    
    /** Fills all elements of grid with randomly generated values,
     * as described in part (a)
     * Precondition: grid is not null.
     *     grid has at least one element.
     */
    public void repopulate() {
        
        /* TO BE IMPLEMENTED IN PART (A) */
        for (int r = 0; r < grid[0].length; r++) {
            for (int c = 0; c < grid.length; c++) {
                int value = 0;
                
                // if MAX is less than 10 then there's no chance for
                // any random value to meet problem requirements and
                // the while() loop will spin forever. Guard against
                // that by setting initial value to something that
                // will prevent entering the loop all together.
                if (MAX < 10) {
                    value = 10;
                }
                
                while (value % 10 == 0 && value % 100 != 0) {
                    value = (int) (Math.random() * MAX) + 1;
                }
                
                grid[r][c] = value;
            }
        }
    }

    /** Returns the number of columns in grid that are in increasing order,
     * as described in part (b)
     * Precondition: grid is not null.
     *    grid has at least one element.
     */
    public int countIncreasingCols() {
        //add a comment
        /* TO BE IMPLEMENTED IN PART (B) */
        int count = 0;
        
        for (int c = 0; c < grid[0].length; c++) {
            boolean increasing = false;
            for (int r = 1; increasing && r < grid.length; r++) {
                increasing = (grid[r-1][c] > grid[r][c]);
            }
            if (increasing) {
                count++;
            }
        }
        
        return count;
    }
    
    // There may be instance variables, constructors, and methods that are not shown.
}