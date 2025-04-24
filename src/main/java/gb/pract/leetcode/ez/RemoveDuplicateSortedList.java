package gb.pract.leetcode.ez;

public class RemoveDuplicateSortedList {

    public static void main(String[] args) {
        ListNodeE l3 = new ListNodeE(2, null);
        ListNodeE l2 = new ListNodeE(1, l3);
        ListNodeE l1 = new ListNodeE(1, l2);

        System.out.println(deleteDuplicates(l1));
    }
    public static ListNodeE deleteDuplicates(ListNodeE head) {

        ListNodeE fic = new ListNodeE(-1);
        ListNodeE current = fic;

        while(head.next != null){

            current.next = head.next;

            if(head.val == head.next.val){
                continue;
            }
            head = head.next;
            current = current.next;
        }

        return fic.next;

    }



    public static class ListNodeE {
        int val;
        ListNodeE next;

        ListNodeE() {
        }

        ListNodeE(int val) {
            this.val = val;
        }

        ListNodeE(int val, ListNodeE next) {
            this.val = val;
            this.next = next;
        }
    }
}
