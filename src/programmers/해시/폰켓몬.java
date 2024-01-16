package programmers.해시;

import java.util.HashMap;

public class 폰켓몬 {

    public static void main(String[] args) {
        int[] nums1 = {3,3,3,2,2,2};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,1,2,3};
        System.out.println(solution(nums3));
    }

    public static int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int size = nums.length / 2;
        int typeSize = map.keySet().size();
        int answer;
        if (size < typeSize) {
            answer = size;
        } else {
            answer = typeSize;
        }
        return answer;
    }
}
