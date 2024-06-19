package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void cicdTest() {
        System.out.println("ci cd test");
        Assert.assertTrue(true);
    }
}
