package gb.pract.leetcode.med;


public class AddTwoNumbersNode {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(4, l3);
        ListNode head1 = new ListNode(2, l2);


        ListNode l4 = new ListNode(1, null);
        ListNode l33 = new ListNode(4, l4);
        ListNode l22 = new ListNode(6, l33);
        ListNode head2 = new ListNode(5, l22);

        System.out.println(addTwoNumbers(head1, head2));




        ListNode l4w92 = new ListNode(9, null);
        ListNode l3w92 = new ListNode(9, l4w92);
        ListNode l2w92 = new ListNode(9, l3w92);
        ListNode head2w9 = new ListNode(9, l2w92);

        ListNode l7w91 = new ListNode(9, null);
        ListNode l6w91 = new ListNode(9, l7w91);
        ListNode l5w91 = new ListNode(9, l6w91);
        ListNode l4w91 = new ListNode(9, l5w91);
        ListNode l3w91 = new ListNode(9, l4w91);
        ListNode l2w91 = new ListNode(9, l3w91);
        ListNode head1w9 = new ListNode(9, l2w91);

        System.out.println(addTwoNumbers(head1w9, head2w9));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1, null);
        ListNode f = result;
        int ol = 0;

        while (l1 != null || l2 != null) {

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;


            int cur = val1 + val2 + ol;
            ol = cur / 10; // новый остаток
            cur %= 10;

//            if (ol > 0) {
//                cur += ol;
//            }
//            ol = 0; // остаток

//            if (cur >= 10) {
//                ol = 1;
//                cur -= 10;
//            }

            f.next = new ListNode(cur);
            f = f.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

//
//            if (l1.next != null){
//                l1 = l1.next;
//            }
//            if(l2.next != null){
//                l2 = l2.next;
//            }
//
//            if (l1.next == null && l2.next == null) {
//                break;
//            }
        }

//        if (l1.next != null) {
//            ListNode fromOl = new ListNode(ol);
//            f.next = addTwoNumbers(l1.next, fromOl);
//            f = f.next;
//        } else if (l2.next != null) {
//            ListNode fromOl = new ListNode(ol);
//            f.next = addTwoNumbers(l2.next, fromOl);
//            f = f.next;
//        }

        if (ol > 0) {
            f.next = new ListNode(ol);
        }

//        if(ol != 0){
//            f.next = new ListNode(ol, null);
//        }

        return result.next;
    }

    private static class ListNode {
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


