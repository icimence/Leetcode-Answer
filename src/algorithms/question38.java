package algorithms;

public class question38 {
    static class Solution{
        public String countAndSay(int n){
            StringBuilder res = new StringBuilder();
            String prev;
            int chCount=0;
            char ch=' ';
            if (n == 1)
                return "1";
            else
                prev = countAndSay(n - 1);
            for (int i = 0; i< prev.length();i++){
                if (prev.charAt(i) != ch ) {
                    if (i != 0){
                        res.append(chCount);
                        res.append(ch);
                    }
                    ch = prev.charAt(i);
                    chCount=1;

                }
                else{
                    chCount++;
                }
            }
            res.append(chCount);
            res.append(ch);
            return res.toString();
        }
    }
}
