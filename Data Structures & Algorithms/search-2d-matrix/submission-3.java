class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0; 
        int high = n - 1;
        int ans = -1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(matrix[mid][m - 1] == target)
            return true;

            else if(target < matrix[mid][m - 1])
            {
                ans = mid;
                high = mid - 1;
            }
            
            else
            low = mid + 1;
        }
        if(ans == -1)
        return false;
        
        int l = 0;
        int h = m - 1;
        while(l <= h)
        {
            int mid = (l + h) / 2;
            if(matrix[ans][mid] == target)
            return true;

            else if(target < matrix[ans][mid])
            h = mid - 1;

            else
            l = mid + 1;
        }
        return false;
    }
}
