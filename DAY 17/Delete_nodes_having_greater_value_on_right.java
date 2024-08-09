class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        int len = length(head);
        int[] ans = new int[len];
        ListNode newHead=reverse(head);
        for(int i=len-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=newHead.val){
                stack.pop();
            }
            if(!stack.isEmpty()){
               ans[i]=stack.peek();
            }else{
               ans[i]=0;
            }
            stack.push(newHead.val);
            newHead=newHead.next;
        }
        return ans;
    }

    public int length(ListNode head){
        if(head==null) return 0;
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }

    public ListNode reverse(ListNode head){
          if(head==null || head.next==null){
              return head;
          }
          ListNode secondLast=head.next;
          ListNode rev=reverse(head.next);
          secondLast.next=head;
          head.next=null;
          return rev;
    }
}