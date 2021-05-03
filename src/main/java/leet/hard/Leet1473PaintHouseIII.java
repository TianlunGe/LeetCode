package leet.hard;

import java.util.Arrays;

public class Leet1473PaintHouseIII {

    public static void main(String[] args) {
        Leet1473PaintHouseIII solution = new Leet1473PaintHouseIII();
        int[] house = {0,0,0,0,0};
        int[][] cost =  {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5, n = 2, target = 3;
        System.out.println(solution.minCost(house, cost, m, n, target));
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k] 表示第i个房子，颜色为j且是第k个分组时花费最小值
        int[][][] dp = new int[m][n][target];
        // -1 表示无法涂，比如第一个房子不可能属于大于第一的分组
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        if (houses[0] == 0) {
            // 第一个房子未涂，可选1~n各种颜色，花费为对应cost
            for (int i = 0; i < n; i++) {
                dp[0][i][0] = cost[0][i];
            }
        } else {
            // 第一个房子已涂，花费0，其他颜色都为-1
            dp[0][houses[0] - 1][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            int[][] pre = dp[i - 1];
            if (houses[i] == 0) {
                // 第i个房子没涂，可选1~n种颜色
                for (int k = 0; k < n; k++) {
                    int c = cost[i][k];
                    for (int l = 0; l < Math.min(i + 1, target); l++) {
                        if (l == 0) {
                            // 属于第一分组，颜色和i-1一样
                            dp[i][k][l] = pre[k][l] < 0 ? -1 : pre[k][l] + c;
                        } else {
                            // 属于第l分组，遍历第i-1个房子，如果i-1和当前一样，取i-1也是第l分组的；如果i-1和当前不一样，当前分组加1，i-1取l-1分组
                            // 取大于等于0的最小值，加上当前房子涂色cost；如果都小于0，说明不是可行选择，等于-1
                            int min = -1;
                            for (int j = 0; j < n; j++) {
                                int idx = j == k ? l : l - 1;
                                if (min < 0) {
                                    min = pre[j][idx];
                                } else {
                                    min = pre[j][idx] < 0 ? min : Math.min(min, pre[j][idx]);
                                }
                            }
                            dp[i][k][l] = min < 0 ? -1 : min + c;
                        }
                    }
                }
            } else {
                // 第i个房子已涂，颜色确定，只要找当前颜色属于1~target分组时的花费
                int color = houses[i] - 1;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < target; k++) {
                        if (j == color) {
                            // i-1颜色和当前颜色相同，分组不变，取大于等于0最小值
                            if (dp[i][color][k] < 0) {
                                dp[i][color][k] = pre[j][k];
                            } else {
                                dp[i][color][k] = pre[j][k] < 0 ? dp[i][color][k] : Math.min(dp[i][color][k], pre[j][k]);
                            }
                        } else {
                            // i-1颜色和当前颜色不同，分组+1，用大于等于0最小值覆盖
                            if (k + 1 >= target) {
                                continue;
                            }
                            if (dp[i][color][k + 1] < 0) {
                                dp[i][color][k + 1] = pre[j][k];
                            } else {
                                dp[i][color][k + 1] = pre[j][k] < 0 ? dp[i][color][k + 1] : Math.min(dp[i][color][k + 1], pre[j][k]);
                            }
                        }
                    }
                }
            }
        }
        // 取dp[m - 1][i][target - 1]  i 在[0, n)最小值，如果全小于0，返回-1
        int ans = -1;
        int[][] ansArr = dp[m - 1];
        for (int i = 0; i < n; i++) {
            if (ans < 0) {
                ans = ansArr[i][target - 1];
            } else {
                ans = ansArr[i][target - 1] < 0 ? ans : Math.min(ans, ansArr[i][target - 1]);
            }
        }
        return ans;
    }

    // 空间优化，当前房子颜色最小花费只与前面相邻的颜色相关，因此只需要保存前状态，不需要长度为m的状态数据
    public int minCost2(int[] houses, int[][] cost, int m, int n, int target) {
        int[][] pre = new int[n][target];
        int[][] cur = new int[n][target];
        fill(pre);

        if (houses[0] == 0) {
            for (int i = 0; i < n; i++) {
                pre[i][0] = cost[0][i];
            }
        } else {
            pre[houses[0] - 1][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            fill(cur);
            if (houses[i] == 0) {
                for (int k = 0; k < n; k++) {
                    int c = cost[i][k];
                    for (int l = 0; l < Math.min(i + 1, target); l++) {
                        if (l == 0) {
                            cur[k][l] = pre[k][l] < 0 ? -1 : pre[k][l] + c;
                        } else {
                            int min = -1;
                            for (int j = 0; j < n; j++) {
                                int idx = j == k ? l : l - 1;
                                if (min < 0) {
                                    min = pre[j][idx];
                                } else {
                                    min = pre[j][idx] < 0 ? min : Math.min(min, pre[j][idx]);
                                }
                            }
                            cur[k][l] = min < 0 ? -1 : min + c;
                        }
                    }
                }
            } else {
                int color = houses[i] - 1;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < target; k++) {
                        if (j == color) {
                            if (cur[color][k] < 0) {
                                cur[color][k] = pre[j][k];
                            } else {
                                cur[color][k] = pre[j][k] < 0 ? cur[color][k] : Math.min(cur[color][k], pre[j][k]);
                            }
                        } else {
                            if (k + 1 >= target) {
                                continue;
                            }
                            if (cur[color][k + 1] < 0) {
                                cur[color][k + 1] = pre[j][k];
                            } else {
                                cur[color][k + 1] = pre[j][k] < 0 ? cur[color][k + 1] : Math.min(cur[color][k + 1], pre[j][k]);
                            }
                        }
                    }
                }
            }
            int[][] swap = pre;
            pre = cur;
            cur = swap;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (ans < 0) {
                ans = pre[i][target - 1];
            } else {
                ans = pre[i][target - 1] < 0 ? ans : Math.min(ans, pre[i][target - 1]);
            }
        }
        return ans;
    }

    private void fill(int[][] arr) {
        for (int[] tmp : arr) {
            Arrays.fill(tmp, -1);
        }
    }

}
