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
                
                while (value % 10 != 0 || value % 100 == 0) {
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
        
        ArrayList<Integer> metaData = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; grid[i] != null && j < grid[i].length; i++) {
        		if (metaData.size() <= j) {
        			metaData.add(grid[i][j]);
        	    } else if (metaData.get(j) != null) {
        			if (metaData.get(j) < grid[i][j]) {
        				metaData.set(j, grid[i][j]);
        			} else {
        				metaData.set(j, null);
        			}
        		} else {
        			//do nothing
        		}
        	}
        }
        int count = 0;
        for (int k = 0; k < metaData.size(); k++) {
        	if (metaData.get(k) != null)
        		count++;
        }
        return count;
    }
    
    // There may be instance variables, constructors, and methods that are not shown.
}