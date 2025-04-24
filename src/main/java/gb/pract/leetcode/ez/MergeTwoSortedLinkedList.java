package gb.pract.leetcode.ez;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode f = new ListNode(-1);
        ListNode cur = f;

        while (list1 != null || list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
            } else {
                cur.next = list2;
            }
            cur = cur.next;
        }

        if(list1.next != null){
            cur.next = list1;
        }else {
            cur.next = list2;
        }
        return f.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
