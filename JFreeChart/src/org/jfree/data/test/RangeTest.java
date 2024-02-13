package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range null_range1;
    private Range null_range2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    // Initialize several ranges to use for testing
    @Before
    public void setUp() throws Exception { 
        exampleRange1 = new Range(-3, 3);
        exampleRange2 = new Range(-20, -10);
        exampleRange3 = new Range(5, 9);
        exampleRange4 = new Range(-15, 0); 
    }

    // Contains Method
    // This test covers a value below the lower boundary of the range
    // in the contains method
    @Test
    public void test_contains_belowLowerBoundary() {
        assertFalse("False should be returned for -4 in range -3 to 3.",
        exampleRange1.contains(-4));
    }

    // This test covers a value on the lower boundary of the range
    // in the contains method
    @Test
    public void test_contains_onLowerBoundary() {
        assertTrue("True should be returned for -3 in range -3 to 3.",
        exampleRange1.contains(-3));
    }
    
    // This test covers a value within the range and very near
    // the lower boundary of the range in the contains method
    @Test
    public void test_contains_nearLowerBoundary() {
        assertTrue("True should be returned for -2.9 in range -3 to 3.",
        exampleRange1.contains(-2.9));
    }

    // This test covers a value within the range and very near
    // the upper boundary of the range in the contains method
    @Test
    public void test_contains_nearUpperBoundary() {
        assertTrue("True should be returned for 2.9 in range -3 to 3.",
        exampleRange1.contains(2.9));
    }

    // This test covers a value on the upper boundary of the range
    // in the contains method
    @Test
    public void test_contains_onUpperBoundary() {
        assertTrue("True should be returned for 3 in range -3 to 3.",
        exampleRange1.contains(3));
    }

    // This test covers a value above the upper boundary of the range
    // in the contains method
    @Test
    public void test_contains_aboveUpperBoundary() {
        assertFalse("False should be returned for 9 in range -3 to 3.",
        exampleRange1.contains(9));
    }

    // getLength Method
    // This test covers a range with two negative bounds
    // in the getLength method
    @Test
    public void test_getLength_bothNegative() {
        assertEquals("The length of range -20 to -10 should be 11", 10,
        exampleRange2.getLength(), .000000001d);
    }

    // This test covers a range with one negative and one
    // positive bound in the getLength method
    @Test
    public void test_getLength_NegativeAndPositive() {
        assertEquals("The length of range -3 to 3 should be 7", 6,
        exampleRange1.getLength(), .000000001d);
    }

    // This test covers a range with two positive bounds
    // in the getLength method
    @Test
    public void test_getLength_bothPositive() {
        assertEquals("The length of range 5 to 9 should be 5", 4,
        exampleRange3.getLength(), .000000001d);
    }
    
    // getLowerBound
    // This test covers a range with a positive lower bound
    // in the getLength method
    @Test
    public void test_getLowerBound_Positive() {
        assertEquals("The lower bound should be 5", 5,
        exampleRange3.getLowerBound(), .000000001d);
    }

    // This test covers a range with a negative lower bound
    // in the getLength method
    @Test
    public void test_getLowerBound_Negative() {
        assertEquals("The lower bound should be -3", -3,
        exampleRange1.getLowerBound(), .000000001d);
    }
    
    // intersects Method
    // This test covers two ranges that overlap on the upper bound
    // in the intersects method
    @Test
    public void test_intersects_upperBoundOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and 1 to 10 overlapping",
        exampleRange1.intersects(1, 10));
    }

    // This test covers two ranges that overlap on the lower bound
    // in the intersects method
    @Test
    public void test_intersects_lowerBoundOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -5 to -2 overlapping",
        exampleRange1.intersects(-5, -2));
    }

    // This test covers two ranges where the range that calls the method
    // is completely contained the range provided by the arguments
    // in the intersects method
    @Test
    public void test_intersects_rangeOneCompletelyContainedOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -5 to 19 overlapping",
        exampleRange1.intersects(-5, 10));
    }

    // This test covers two ranges where the range provided by the arguments
    // is completely contained within the range that calls the intersects method
    @Test
    public void test_intersects_rangeTwoCompletelyContainedOverlap() {
        assertTrue("True should be returned for ranges -3 to 3 and -1 to 1 overlapping",
        exampleRange1.intersects(-1, 1));
    }

    // This test covers two ranges that connect on the lower bound
    // without overlapping in the intersects method
    @Test
    public void test_intersects_rangeOnLowerBound() {
        assertTrue("True should be returned for ranges -3 to 3 and -10 to -3 overlapping",
        exampleRange1.intersects(-10, -3));
    }
    
    // This test covers two ranges that connect on the upper bound
    // without overlapping in the intersects method
    @Test
    public void test_intersects_rangeOnUpperBound() {
        assertTrue("True should be returned for ranges -3 to 3 and 3 to 11 overlapping",
        exampleRange1.intersects(3, 11));
    }
    
    // This test covers two ranges that do not intersect where the range provided
    // by the arguments is below the range that calls the intersects method
    @Test
    public void test_intersects_rangeBelowLowerBound() {
        assertFalse("False should be returned for ranges -3 to 3 and -10 to -5 overlapping",
        exampleRange1.intersects(-10, -5));
    }

    // This test covers two ranges that do not intersect where the range provided
    // by the arguments is above the range that calls the intersects method
    @Test
    public void test_intersects_rangeAboveUpperBound() {
        assertFalse("False should be returned for ranges -3 to 3 and 20 to 22 overlapping",
        exampleRange1.intersects(20, 22));
    }
    
    // Combine
    // This test covers combining two ranges that overlap
    @Test
    public void test_combine_rangesOverlap() {
    	Range newRange = Range.combine(exampleRange4, exampleRange2);
    	assertEquals("The new lower bound should be -20", -20,
    	newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 0", 0,
    	newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges that do not overlap
    @Test
    public void test_combine_rangesNoOverlap() {
    	Range newRange = Range.combine(exampleRange1, exampleRange2);
    	assertEquals("The new lower bound should be -20", -20,
    	newRange.getLowerBound(), .000000001d);
    	assertEquals("The new upper bound should be 3", 3,
    	newRange.getUpperBound(), .000000001d);
    }

    // This test covers combining two ranges where
    // one range is null
    @Test
    public void test_combine_oneRangeNull() {
        Range newRange = Range.combine(exampleRange1, null_range1);
        assertEquals("The new lower bound should be -3", -3,
        newRange.getLowerBound(), .000000001d);
        assertEquals("The new upper bound should be 3", 3,
        newRange.getUpperBound(), .000000001d);
    }
    
    // This test covers combining two ranges where
    // both ranges are null
    @Test
    public void test_combine_bothRangeNull() {
        assertNull("The new range should be null", 
        Range.combine(null_range1, null_range2));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}