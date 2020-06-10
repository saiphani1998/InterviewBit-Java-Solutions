/*
* Write a program to solve a Sudoku puzzle by filling the empty cells.
* Empty cells are indicated by the character '.'
* You may assume that there will be only one unique solution.
* Example :
    * [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
        * and we would expect your program to modify the above array of array of characters to
    * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
*
* Approach: Write a function that checks after assigning the current index the grid becomes unsafe or not.
    * Create a recursive function which takes a grid.
    * Check for any unassigned location.
        * If present then assign a number from 1 to 9, check if assigning the number to current index makes the grid unsafe or not,
        * if safe then recursively call the function for all safe cases from 0 to 9.
            * if any recursive call returns true, end the loop and return true.
            * If no recursive call returns true then return false.
    * If there is no unassigned location then return true.
* */

public class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solveSudokuUtil(a);
    }
    public boolean solveSudokuUtil(ArrayList<ArrayList<Character>> a) {
        int row = -1;
        int col = -1;

        boolean isEmpty = false;
        for (int i = 0; i<a.size(); i++) {
            for (int j = 0; j<a.size(); j++) {
                if (a.get(i).get(j).equals(new Character('.'))) {
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty) {
                break;
            }
        }

        if (!isEmpty) {
            return true;
        }
        for (int num = 1; num<=a.size(); num++) {
            if (isSafe(a, row, col, num)) {
                a.get(row).set(col,(char)(num+'0'));
                if (solveSudokuUtil(a)) {
                    return true;
                } else {
                    a.get(row).set(col,'.');
                }
            }
        }
        return false;
    }

    public boolean isSafe(ArrayList<ArrayList<Character>> a, int row, int col, int num) {
        for (int i = 0; i<a.get(row).size(); i++) {
            if (a.get(row).get(i).equals(new Character((char)(num+'0')))) {
                return false;
            }
        }

        for (int i = 0; i<a.size(); i++) {
            if (a.get(i).get(col).equals(new Character((char)(num+'0')))) {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(a.size());
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (a.get(r).get(d).equals(new Character((char)(num+'0')))) {
                    return false;
                }
            }
        }
        return true;
    }
}
