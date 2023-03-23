package LinkedList;

public class test {
    public static boolean main(String[] args) {
        test t = new test();
        String a = "abcde";
        String b = "cdsa";
        String c = "abcdg";
//        return Integer.valueOf(a) < Integer.valueOf(b);
        return Integer.valueOf(a) > Integer.valueOf(c);
    }


    public static long count(ListNode head) {
        ListNode cur = head;
        long sum = 0, i = 1;
        while (cur != null) {
            sum += cur.val * i;
            i *= 10;
            cur = cur.next;
        }
        return sum;
    }

    public ListNode reverseAll (ListNode head) {
        if (head == null || head.next == null) {
            return head; //base case
        }
        ListNode last = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
}

