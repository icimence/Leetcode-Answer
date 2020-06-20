package algorithms;

public class question23 {
    static class Solution {
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = new ListNode(0);
            ListNode ans = res;
            while (!judgeStop(lists)){
                int index = returnIndexOfMin(lists);
                res.next = new ListNode(lists[index].val);
                res = res.next;
                lists[index] = lists[index].next;
            }
            return ans.next;
        }
        public static boolean judgeStop(ListNode[] lists){
            for (ListNode list : lists) {
                if (list != null)
                    return false;
            }
            return true;
        }
        public static int returnIndexOfMin(ListNode[] lists){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0 ; i < lists.length;i++){
                if (lists[i] == null)
                    continue;
                if (lists[i].val < min){
                    index = i ;
                    min  = lists[i].val;
                }
            }
            return index;
        }
    }
}
