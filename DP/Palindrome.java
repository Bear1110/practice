package zzzafasdfasdfasdf;

public class Palindrome {

    static int[][] dp;
    static int[][] p;

    static String s;


    public static void main(String[] args) {
        String s = "1545335451";
        Palindrome.s = s;

        int N = s.length();
        dp = new int[N][N];
        p = new int[N][N];

        System.out.println("最長迴文子序列的長度是" + f(0, N - 1));
        System.out.println("最長迴文子序列是");
        print(0, N - 1);
    }

    public static int f(int i, int j) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j]; // 已經知道這個的結果了

        // 左右兩端字元相等，定能形成更長迴文，同時從兩端縮小問題範疇。
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = f(i + 1, j - 1) + 2;
            p[i][j] = 0;
        }

        // 刪除左端字元比較好。
        else if (f(i + 1, j) > f(i, j - 1)) {
            dp[i][j] = f(i + 1, j);
            p[i][j] = 1;
        }

        // 刪除右端字元比較好。
        else if (f(i + 1, j) < f(i, j - 1)) {
            dp[i][j] = f(i, j - 1);
            p[i][j] = 2;
        }
        // 可以刪除其中一端的字元，都一樣好。
        else /* if (f(i+1, j) == f(i, j-1)) */ {
            dp[i][j] = f(i, j - 1);
            p[i][j] = 3;
        }

        return dp[i][j];
    }

    static void print(int i, int j) {
        if (i > j)
            return;

        // 當迴文長度為奇數，最中間的字母。
        if (i == j)
            System.out.print(s.charAt(i));

        // 兩端字母一樣。
        else if (p[i][j] == 0) {
            System.out.print(s.charAt(i));
            print(i + 1, j - 1);
            System.out.print(s.charAt(i));
        }

        // 刪除左端字元。
        else if (p[i][j] == 1)
            print(i + 1, j);

        // 刪除右端字元。
        else
            print(i, j - 1);
    }

}
