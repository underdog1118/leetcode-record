package LinkedList;

public class test {
    public static void main(String[] args) {
        // Definition for singly-linked list.
        ListNode head = new ListNode(1);
        ListNode first =  new ListNode(9);
        ListNode second = new ListNode(9);
        ListNode second2 = new ListNode(9);
        ListNode second3 = new ListNode(9);
        ListNode second4 = new ListNode(9);
        ListNode second5 = new ListNode(9);
        ListNode second6 = new ListNode(9);
        ListNode second7 = new ListNode(9);
        ListNode second8 = new ListNode(9);
        ListNode second9 = new ListNode(9);
        head.next = first;
        first.next = second;
        second.next = second2;
        second2.next = second3;
        second3.next = second4;
        second4.next = second5;
        second5.next = second6;
        second6.next = second7;
        second7.next = second8;
        second8.next = second9;

//        System.out.println("Linked list");
//        while (head != null)  {
//            System.out.println(head.val);
//            head = head.next;
//        }

        System.out.println(count(head));
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

