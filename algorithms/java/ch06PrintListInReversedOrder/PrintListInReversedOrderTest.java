package ch06PrintListInReversedOrder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-18
 * Time: 00:14
 */
public class PrintListInReversedOrderTest {
    private PrintListInReversedOrder printListInReversedOrder = new PrintListInReversedOrder();

    @Test
    public void test_normal_feature() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        int[] result1 = printListInReversedOrder.reversePrint(head);
        int[] result2 = printListInReversedOrder.reversePrint2(head);
        int[] expect = {3, 2, 1};
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result1));
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result2));
    }

    @Test
    public void test_just_one_node() {
        ListNode head = new ListNode(1);
        int[] result1 = printListInReversedOrder.reversePrint(head);
        int[] result2 = printListInReversedOrder.reversePrint2(head);
        int[] expect = {1};
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result1));
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result2));
    }

    @Test
    public void test_null() {
        ListNode head = null;
        int[] result1 = printListInReversedOrder.reversePrint(head);
        int[] result2 = printListInReversedOrder.reversePrint2(head);
        int[] expect = {};
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result1));
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(result2));
    }
}
