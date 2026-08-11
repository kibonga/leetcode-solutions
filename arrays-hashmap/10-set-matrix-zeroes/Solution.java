class Solution {
    // BUG (first version):
    if (matrix[i][j] != 0) {   // should have been == 0
        rows.add(i);
        cols.add(j);
    }
}
