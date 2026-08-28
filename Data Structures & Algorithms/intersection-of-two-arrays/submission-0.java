class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums1.length; i++)
        {
            int low = 0;
            int high = nums2.length - 1;
            while(low <= high)
            {
                int mid = (high + low) / 2;
                if(nums2[mid] == nums1[i])
                {
                    set.add(nums2[mid]);
                    break;
                }
                else if(nums2[mid] < nums1[i])
                low = mid + 1;
                else
                high = mid - 1;
            }
        }
        int arr[] = new int[set.size()];
        int j = 0;
        for(int i : set)
        {
            arr[j] = i;
            j++;
        }
        return arr;
    }
}