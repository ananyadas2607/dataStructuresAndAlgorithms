package Pepcoding.LinkedList;

public class questions {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    //LC 876 - Middle of a linked list
    public static ListNode midNode(ListNode head){
        if(head == null || head.next==null)
            return head;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null) //To get the second mid in even no of nodes:
                                             // fast.next!=null and fast.next.next!=null
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //Reverse of a linked list-Pointer reverse
    public ListNode reverse(ListNode head){
        if(head==null || head.next ==null)
            return head;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode forward=curr.next;

            curr.next=prev;
            prev=curr;

            curr=forward;
        }
        return prev;
    }

    //Fold of a linked List / Reorder Linked List(LC 143)
    // T: O(n), S: O(1)
    public void reorderList(ListNode head) {

        if(head==null || head.next ==null)
            return;

        ListNode mid=midNode(head);
        ListNode newHead=mid.next;
        mid.next=null;
        newHead=reverse(newHead);

        ListNode c1=head, c2=newHead;
        while(c1!=null && c2!=null){
            ListNode f1=c1.next, f2=c2.next;

            c1.next=c2;
            c2.next=f1;

            c1=f1;
            c2=f2;
        }
    }

    // T: O(n), S: O(1)
    public  void unfold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode c1 = head, c2 = head.next, nHead = c2;
        while (c2 != null && c2.next != null) {
            ListNode f1 = c2.next;

            c1.next = f1;
            c2.next = f1.next;

            c1 = c1.next; // c1 = f1;
            c2 = c2.next; // c2 = c1.next;
        }

        c1.next = null;
        nHead = reverse(nHead);
        c1.next = nHead;
    }
    // T: O(n + m), S: O(1)
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;
        ListNode head = dummy.next;
        dummy.next = null; // delete dummy;
        return head;
    }

    public  ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        return mergeTwoLists(mergeSort(head), mergeSort(nHead));
    }

    public ListNode mergeKSortedList_01(ListNode[] arr) {
        ListNode res = null;
        for (ListNode list : arr) {
            res = mergeTwoLists(res, list);
        }

        return res;
    }
}
