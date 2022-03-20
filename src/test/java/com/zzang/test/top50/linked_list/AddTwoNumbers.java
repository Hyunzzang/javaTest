package com.zzang.test.top50.linked_list;

class ListNode {

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

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode node = solve_1(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve_1(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode rootNode = resNode;

        int plus = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            } else {
                l1Val = 0;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            } else {
                l2Val = 0;
            }

            int val = l1Val + l2Val + plus;
            if (val > 9) {
                plus = 1;
                val -= 10;
            } else {
                plus = 0;
            }

            resNode.next = new ListNode(val);
            resNode = resNode.next;
        }
        if (plus == 1) {
            resNode.next = new ListNode(1);
        }

        return rootNode.next;
    }


    public static ListNode solve(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }
      if (carry == 1) {
        p3.next = new ListNode(1);
      }
        return newHead.next;
    }
}
