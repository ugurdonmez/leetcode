/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int sum = carry + l2.val;
                carry = sum / 10;
                ListNode node = new ListNode(sum % 10);
                node.next = result;
                result = node;
                l2 = l2.next;
            } else if (l2 == null) {
                int sum = carry + l1.val;
                carry = sum / 10;
                ListNode node = new ListNode(sum % 10);
                node.next = result;
                result = node;
                l1 = l1.next;
            } else {
                int sum = carry + l1.val + l2.val;
                carry = sum / 10;
                ListNode node = new ListNode(sum % 10);
                node.next = result;
                result = node;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = result;
            result = node;
        }

        return reverse(result);
    }



    public ListNode addTwoNumbersRev(ListNode l1, ListNode l2) {

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length1 > length2) {
            int dif = length1 - length2;

            while (dif > 0) {
                ListNode newNode = new ListNode(0);
                newNode.next = l2;
                l2 = newNode;
                dif--;
            }
        }

        if (length2 > length1) {
            int dif = length2 - length1;

            while (dif > 0) {
                ListNode newNode = new ListNode(0);
                newNode.next = l1;
                l1 = newNode;
                dif--;
            }
        }

        Result res = helper(l1, l2);

        if (res.carry != 0) {
            ListNode node = new ListNode(res.carry);
            node.next = res.list;
            return reverse(node);
        } else {
            return reverse(res.list);
        }

    }

    public Result helper(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            int sum = l1.val + l2.val;
            Result res = new Result();
            res.carry = sum / 10;
            res.list = new ListNode(sum % 10);
            return res;
        } else {
            Result resNext = helper(l1.next, l2.next);
            int sum = l1.val + l2.val + resNext.carry;
            Result res = new Result();
            res.carry = sum / 10;
            res.list = new ListNode(sum % 10);
            res.list.next = resNext.list;
            return res;
        }
    }

    public int getLength(ListNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getLength(node.next);
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}

class Result {
    int carry;
    ListNode list;
}

class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
        val = x;
    }
}