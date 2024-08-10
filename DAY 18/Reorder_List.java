class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode n = null;
        ListNode curr = head;
        int c = 0;

        while (curr != null) {
            ListNode ln = new ListNode(curr.val);
            ln.next = n;
            n = ln;
            curr = curr.next;
            c++;
        }

        ListNode m = new ListNode();
        ListNode tr = m;

        int k = c / 2; 
        curr = head;
        ListNode curr1 = n;

        while (k > 0 && curr != null && curr1 != null) {
            tr.next = curr;
            tr = tr.next;
            curr = curr.next;

            tr.next = curr1;
            tr = tr.next;
            curr1 = curr1.next;
            k--;
        }

        if (curr != null && c%2!=0) {
            tr.next = curr;
            tr = tr.next;
        }

        tr.next = null;

        head = m.next;
    }
}