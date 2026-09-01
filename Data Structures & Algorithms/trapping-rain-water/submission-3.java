class Solution {
    public int trap(int[] arr) {
        int left = 0;
int right = arr.length - 1;
int leftM = 0; // Left side ka sabse uncha pillar
int rightM = 0; // Right side ka sabse uncha pillar
int water = 0; // Total paani

while (left < right) { // Jab tak do pointers mil na jayein
    // 2. Faisla: Kaunsa side chota hai?
    if (arr[left] < arr[right]) {
        
        // --- LEFT SIDE CHECK KARO ---
        if (arr[left] >= leftM) {
            // Case A: Current pillar ab tak ke sabse uncha hai
            // To bas Max update karo, paani nahi jamega
            leftM = arr[left]; 
        } else {
            // Case B: Current pillar chota hai
            // To Max height se paani jamega (Difference)
            water += leftM - arr[left];
        }
        
        // 3. Move: Left pointer aage badha
        left++;
        
    } else {
        
        // --- RIGHT SIDE CHECK KARO (Wahi logic, right ke liye) ---
        if (arr[right] >= rightM) {
            rightM = arr[right];
        } else {
            water += rightM - arr[right];
        }
        
        // Move: Right pointer peeche lao
        right--;
    }
}

return water;
    }
}