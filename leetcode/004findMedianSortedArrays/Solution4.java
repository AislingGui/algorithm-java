public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2= tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right){
            int i = left + (right - left) / 2;
            int j = totalLeft - i;
            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else {
                right = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }

    }

    public static void main(String[] args) {
        Solution4 sl4 = new Solution4();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(sl4.findMedianSortedArrays(nums1,nums2));
    }
}
