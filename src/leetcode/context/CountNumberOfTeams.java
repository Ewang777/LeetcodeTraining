package leetcode.context;

/**
 * @author shiyuan.tian
 * @date 2020/3/29
 */
public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] rating = {1,2,3,4};
        System.out.println(numTeams(rating));
    }

    public static int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k] ||
                            rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
