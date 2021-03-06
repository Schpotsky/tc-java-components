/**
 * Copyright � 2003, TopCoder, Inc. All rights reserved
 */
package com.topcoder.util.datavalidator.accuracytests;

import com.topcoder.util.datavalidator.AbstractAssociativeObjectValidator;
import com.topcoder.util.datavalidator.AndValidator;
import com.topcoder.util.datavalidator.OrValidator;
import com.topcoder.util.datavalidator.IntegerValidator;
import com.topcoder.util.datavalidator.ObjectValidator;
import com.topcoder.util.datavalidator.StringValidator;
import junit.framework.TestCase;

/**
 * Accuracy tests for the AndValidatorTestCase class.
 *
 * @author snard6
 * @version 1.0
 */
public class AndValidatorTestCase extends TestCase {

    /**
     * Set up environment.
     */
    public void setUp() {
    }

    /**
     * Cleanup environment.
     */
    public void tearDown() {
    }

    /**
     * Tests the and operator with a complex equation
     * if x >= 1 and x <= 101 and x != multiple of 10 
     */
    public void testAndValidatorSimple() {
        AndValidator validator1 = new AndValidator();
        
        assertNotNull(validator1);
        
        validator1.addValidator(IntegerValidator.inRange(1, 101));
        ObjectValidator nottenvalidator = new IntegerValidator() {
            public boolean valid(int value) {
                return value % 10 != 0;
            }
            public String getMessage(int value) {
                return null;
            }
        };
        
        assertNotNull(nottenvalidator);
        
        validator1.addValidator(nottenvalidator);
        
        assertTrue(validator1.valid("1"));
        assertTrue(validator1.valid("33"));
        assertTrue(validator1.valid("101"));
        assertFalse(validator1.valid("-30"));
        assertFalse(validator1.valid("30"));
        assertFalse(validator1.valid("100"));
        assertFalse(validator1.valid("One"));
    }
    
    /**
     * Tests if the object is between 1 and 80 and is exactly two digits long
     */
    public void testAndValidatorComplex() {
        AndValidator validator1 = new AndValidator();
        
        assertNotNull(validator1);
        
        validator1.addValidator(IntegerValidator.inRange(1, 80));
        validator1.addValidator(StringValidator.hasLength(
            IntegerValidator.inRange(2, 2)));
        
        assertTrue(validator1.valid("10"));
        assertTrue(validator1.valid("33"));
        assertTrue(validator1.valid("78"));
        assertFalse(validator1.valid("-3"));
        assertFalse(validator1.valid(""));
        assertFalse(validator1.valid("90"));
        assertFalse(validator1.valid("-10"));
    }
    
    /**
     * We use AND/OR, so that it still has to be between 1 and 101
     * And it has to either be between -50 and 50, or have 3 to 5 length
     * Essentially 1-50 and 100-101 will work
     */
    public void testAndValidatorMixture() {
        OrValidator orvalidator = new OrValidator();
        
        assertNotNull(orvalidator);
        
        orvalidator.addValidator(IntegerValidator.inRange(-50, 50));
        orvalidator.addValidator(StringValidator.hasLength(
            IntegerValidator.inRange(3, 5)));
        
        AndValidator validator1 = new AndValidator();
        
        assertNotNull(validator1);
        
        validator1.addValidator(IntegerValidator.inRange(1, 101));
        validator1.addValidator(orvalidator);
        
        assertTrue(validator1.valid("2"));
        assertTrue(validator1.valid("50"));
        assertTrue(validator1.valid("101"));
        assertFalse(validator1.valid("-3"));
        assertFalse(validator1.valid(""));
        assertFalse(validator1.valid("-45"));
        assertFalse(validator1.valid("300"));
    }
}