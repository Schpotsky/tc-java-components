/*
 * Copyright (C) 2012 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.review.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

/**
 * <p>
 * Unit tests for {@link ReviewApplicationStatus} class.
 * </p>
 *
 * @author sparemax
 * @version 1.0
 */
public class ReviewApplicationStatusUnitTests {
    /**
     * <p>
     * Represents the <code>ReviewApplicationStatus</code> instance used in tests.
     * </p>
     */
    private ReviewApplicationStatus instance;

    /**
     * <p>
     * Represents the id used in tests.
     * </p>
     */
    private long id = 1;

    /**
     * <p>
     * Represents the name used in tests.
     * </p>
     */
    private String name = "name";

    /**
     * <p>
     * Adapter for earlier versions of JUnit.
     * </p>
     *
     * @return a test suite.
     */
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ReviewApplicationStatusUnitTests.class);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReviewApplicationStatus(long id, String name)</code>.<br>
     * Instance should be correctly created.
     * </p>
     */
    @Test
    public void testCtor() {
        instance = new ReviewApplicationStatus(id, name);

        assertEquals("'id' should be correct.", id, BaseUnitTests.getField(instance, "id"));
        assertEquals("'name' should be correct.", name, BaseUnitTests.getField(instance, "name"));
    }

    /**
     * <p>
     * Accuracy test for the method <code>toString()</code>.<br>
     * The result should be correct.
     * </p>
     */
    @Test
    public void test_toString_1() {
        instance = new ReviewApplicationStatus(id, name);
        String res = instance.toString();

        assertTrue("'toString' should be correct.", res.contains(instance.getClass().getName()));
        assertTrue("'toString' should be correct.", res.contains("id:" + id));
        assertTrue("'toString' should be correct.", res.contains("name:" + name));
    }

    /**
     * <p>
     * Accuracy test for the method <code>toString()</code>.<br>
     * The result should be correct.
     * </p>
     */
    @Test
    public void test_toString_2() {
        instance = new ReviewApplicationStatus(0, null);

        String res = instance.toString();

        assertTrue("'toString' should be correct.", res.contains(instance.getClass().getName()));
        assertTrue("'toString' should be correct.", res.contains("id:0"));
        assertTrue("'toString' should be correct.", res.contains("name:null"));
    }

}