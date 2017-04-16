package zzzafasdfasdfasdf;

public class Zfunction {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abcabcabc";
        int z[] = new int[s.length()]; // z陣列
        z_function(z, s);
        for(int x : z){
            System.out.print(x);
        }
    }



    static void z_function(int[] z, String s) {
        z[0] = s.length(); // z(0)是整個字串的長度

        int L = 0, R = 0; // s[L, R]即是s[j ... j+z(j)-1]。
        for (int i = 1; i < s.length(); ++i) {
            // i'，i用s[L, R]映至i'
            // 向左移動L單位
            // s[L]移到s[0]，減了L；s[i]移到s[i-L]，也是減了L。
            int ii = i - L;

            // j+z(j)映射到字串開頭的位置
            // s[i]移到s[0]，減了i；s[R+1]移到s[R+1-i]，也是減了i。
            int n = R + 1 - i;

            // 已經算好的部份都派不上用場
            if (i > R) {
                // 從s[i]與s[0]開始比對，逐字比下去。
                int x = i;
                while (x < s.length() && s.charAt(x) == s.charAt(x - i))
                    x++;
                z[i] = x - i;

                // 更新s[0 ... z(j)-1] = s[j ... j+z(j)-1]。
                if (x > i) {
                    L = i;
                    R = x - 1;
                } ;
            }
            // s[i ... i+z(i')-1]貼齊或超出s[j ... j+z(j)-1]的右端
            else if (z[ii] >= n) {
                // 從s[R+1]與s[R+1-i]開始比對，逐字比下去。
                int x = R + 1;
                while (x < s.length() && s.charAt(x) == s.charAt(x - i))
                    x++;
                z[i] = x - i;

                // 更新s[0 ... z(j)-1] = s[j ... j+z(j)-1]。
                L = i;
                R = x - 1;
            } else {
                z[i] = z[ii];
            }
        }
    }


//     void z_function()  較簡便寫法
// {
//     memset(z, 0, sizeof(0));    // 初始化為0
//     z[0] = 9;                   // z(0)是整個字串的長度
 
//     int L = 0, R = 1;           // 改成半開區間s[L, R)
//     for (int i=1; i<9; ++i)
//         if (R <= i || z[i-L] >= R-i)
//         {
//             int x = (R <= i ? i : R);
//             while (x < 9 && s[x] == s[x-i]) x++;
//             z[i] = x-i;
//             if (i < x) {L = i; R = x;}
//         }
//         else
//             z[i] = z[i-L];
// }  

}
