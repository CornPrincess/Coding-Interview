package ch05ReplaceSpaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-17
 * Time: 00:36
 */
public class ReplaceSpacesTest {
    private ReplaceSpaces replaceSpaces = new ReplaceSpaces();

    @Test
    public void test_space_in_the_middle_of_string() {
        String s = "hello world";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("hello%20world", result1);
        Assert.assertEquals("hello%20world", result2);
    }

    @Test
    public void test_space_in_the_start_of_string() {
        String s = " helloworld";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("%20helloworld", result1);
        Assert.assertEquals("%20helloworld", result2);
    }

    @Test
    public void test_space_in_the_end_of_string() {
        String s = "helloworld ";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("helloworld%20", result1);
        Assert.assertEquals("helloworld%20", result2);
    }

    @Test
    public void test_contiguous_two_spaces() {
        String s = "hello  world";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("hello%20%20world", result1);
        Assert.assertEquals("hello%20%20world", result2);
    }

    @Test
    public void test_null() {
        String s = null;
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        assertNull(result1);
        assertNull(result2);
    }

    @Test
    public void test_empty_string() {
        String s = "";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("", result1);
        Assert.assertEquals("", result2);
    }

    @Test
    public void test_just_one_space() {
        String s = " ";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("%20", result1);
        Assert.assertEquals("%20", result2);
    }

    @Test
    public void test_just_some_space() {
        String s = "  ";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("%20%20", result1);
        Assert.assertEquals("%20%20", result2);
    }

    @Test
    public void test_just_no_space() {
        String s = "helloworld";
        String result1 = replaceSpaces.replaceSpace(s);
        String result2 = replaceSpaces.replaceSpace2(s);
        Assert.assertEquals("helloworld", result1);
        Assert.assertEquals("helloworld", result2);
    }
}
