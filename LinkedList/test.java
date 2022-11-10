package LinkedList;

public class test {
    public static void main(String[] args) {
        // Definition for singly-linked list.
        ListNote head = new ListNote(0);
        head.next = new ListNote(1);
        System.out.println("Linked list");
        while (head != null)  {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class ListNote{
        int val;
        ListNote next;
        public ListNote(int val){
            this.val = val;
        }
    }
}

