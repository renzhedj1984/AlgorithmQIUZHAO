public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode yaNode = new ListNode(-1);
        ListNode prev = yaNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return yaNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(new int[]{1, 3, 4});
        ListNode l2 = createListNode(new int[]{1, 2, 4});
        new MergeTwoLists().mergeTwoLists(l1, l2);
    }

    private static ListNode createListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode perv = null;
        for (int i = 0; i < nums.length; i++) {
            if (perv == null) {
                head.val = nums[i];
                head.next = new ListNode();
                perv = head.next;
            } else {
                perv.val = nums[i];
                perv.next = new ListNode();
                perv = perv.next;
            }
        }
        return head;
    }

    static class ListNode {
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
