package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.junit.Test;

import org.jmock.*;

public class DataUtilities345Test extends DataUtilities {
	
	 // This test covers valid input for the column index argument and valid
	 // input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithValidInput() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getRowCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(1));
				 one(values).getValue(1, 0); 
				 will(returnValue(2));
				 one(values).getValue(2, 0); 
				 will(returnValue(3));	  
			 }
		 });
		 double result = DataUtilities.calculateColumnTotal(values, 0);
		 // verify
		 assertEquals("Column total should be 6", 6.0, result, .000000001d); 
	 }
	 
	 // This test covers invalid, out of bounds, input for the column index argument 
	 // and valid input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithOutOfBoundsIndex() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getRowCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(1));
				 one(values).getValue(1, 0); 
				 will(returnValue(2));
				 one(values).getValue(2, 0); 
				 will(returnValue(3));	  
			 }
		 });
		 double result = DataUtilities.calculateColumnTotal(values, 1);
		 // verify
		 assertEquals("Column total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the column index argument and valid, all
	 // zero input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithAllZeroValues() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getRowCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(0));
				 one(values).getValue(1, 0); 
				 will(returnValue(0));
				 one(values).getValue(2, 0); 
				 will(returnValue(0));	  
			 }
		 });
		 double result = DataUtilities.calculateColumnTotal(values, 0);
		 // verify
		 assertEquals("Column total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the column index argument and valid, mixed
	 // input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithMixedValues() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getRowCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(-2));
				 one(values).getValue(1, 0); 
				 will(returnValue(0));
				 one(values).getValue(2, 0); 
				 will(returnValue(2));	  
			 }
		 });
		 double result = DataUtilities.calculateColumnTotal(values, 0);
		 // verify
		 assertEquals("Column total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the column index argument and invalid
	 // input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithInvalidInput() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getRowCount();
				 will(returnValue(0));
			 }
		 });
		 double result = DataUtilities.calculateColumnTotal(values, 0);
		 // verify
		 assertEquals("Column total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test checks if InvalidParameterException is thrown with invalid, null
         // input for the data argument in method calculateColumnTotal(data, index)
	 @Test
	 public void calculateColumnTotalWithInvalidDataObject() {
	    try {
	    	DataUtilities.calculateColumnTotal(null, 0); 
	    	fail("Expected InvalidParameterException to be thrown");
	    } catch (NullPointerException e) {
	        fail("Unexpected NullPointerException occurred");
	    } catch (InvalidParameterException e) {
	    	// Expected behavior
	    }
	 }
	 
	 // This test covers valid input for the row index argument and valid
         // input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithValidInput() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getColumnCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(1));
				 one(values).getValue(0, 1); 
				 will(returnValue(2));
				 one(values).getValue(0, 2); 
				 will(returnValue(3));	  
			 }
		 });
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 // verify
		 assertEquals("Row total should be 6", 6.0, result, .000000001d); 
	 }
	 
	 
	 // This test covers invalid, out of bounds, input for the row index argument 
	 // and valid input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithOutOfBoundsIndex() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getColumnCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(1));
				 one(values).getValue(0, 1); 
				 will(returnValue(2));
				 one(values).getValue(0, 2); 
				 will(returnValue(3));	  
			 }
		 });
		 double result = DataUtilities.calculateRowTotal(values, 1);
		 // verify
		 assertEquals("Row total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the row index argument and valid, all
	 // zero input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithAllZeroValues() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getColumnCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(0));
				 one(values).getValue(0, 1); 
				 will(returnValue(0));
				 one(values).getValue(0, 2); 
				 will(returnValue(0));	  
			 }
		 });
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 // verify
		 assertEquals("Row total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the row index argument and valid, mixed
	 // input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithMixedValues() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getColumnCount(); 
				 will(returnValue(3));
				 one(values).getValue(0, 0);
				 will(returnValue(-2));
				 one(values).getValue(0, 1); 
				 will(returnValue(0));
				 one(values).getValue(0, 2); 
				 will(returnValue(2));	  
			 }
		 });
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 // verify
		 assertEquals("Row total should be 0", 0.0, result, .000000001d); 
	 }
	 
	 // This test covers valid input for the row index argument and invalid
	 // input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithInvalidInput() {
		 // setup
		 Mockery context = new Mockery();
		 final Values2D values = context.mock(Values2D.class);
		 context.checking(new Expectations() {
			 {
				 one(values).getColumnCount();
				 will(returnValue(0));
			 }
		 });
		 double result = DataUtilities.calculateRowTotal(values, 0);
		 // verify
		 assertEquals("Row total should be 0", 0.0, result, .000000001d); 
	 } 
	 
	 // This test checks if InvalidParameterException is thrown with invalid, null
         // input for the data argument in method calculateRowTotal(data, index)
	 @Test
	 public void calculateRowTotalWithInvalidDataObject() {
	    try {
	    	DataUtilities.calculateRowTotal(null, 0); 
	    	fail("Expected InvalidParameterException to be thrown");
	    } catch (NullPointerException e) {
	        fail("Unexpected NullPointerException occurred");
	    } catch (InvalidParameterException e) {
	    	// Expected behavior
	    }
	 }

	
	@Test
	public void testCreateNumberArray() {
		
		double[] double_arr = {4.0, 4.5, 5.0, 5.5, 6.0};
		int arr_size = 5;
		Number[] num_arr = DataUtilities.createNumberArray(double_arr);
		
		assertNotNull("Array should not be null", num_arr);
		
		assertEquals("Array sizes should be the same", arr_size, num_arr.length);
		
		for (int i = 0; i < arr_size; i++) {
			assertNotNull("Number array element was null at index: " + i, num_arr[i]);
			boolean equality = (double_arr[i] == num_arr[i].doubleValue());
			assertTrue("Found an inequality between the arrays elements at index: " + i, equality);
		}
		
	}
	
	
	
	
	
	
	@Test
	public void testCreateNumberArray2D() {
		
		double[][] double_matrix = {{1.0, 1.5, 2.0}, {2.5, 3.0, 3.5}};
		int mtrx_rows = 2;
		int mtrx_cols = 3;
		Number[][] num_matrix = DataUtilities.createNumberArray2D(double_matrix);
		
		assertNotNull("Matrix should not be null", num_matrix);
		
		assertEquals("Matrix rows should be the same", mtrx_rows, num_matrix.length);
		
		for (int i = 0; i < mtrx_rows; i++) {
			assertNotNull("Number matrix column was null at row: " + i, num_matrix[i]);
			assertEquals("Matrix column lengths were different at row: " + i, mtrx_cols, num_matrix[i].length);
			for (int j = 0; j < mtrx_cols; j++) {
				assertNotNull("Number matrix element at row: " + i + ", col: " + j + " was null", num_matrix[i][j]);
				boolean equality = (double_matrix[i][j] == num_matrix[i][j].doubleValue());
				assertTrue("Found an inequality between the matrix elements at row: " + i + ", col: " + j, equality);
			}
		}

	}
	
	
	
	
	@Test
    public void testGetCumulativePercentages() {

        Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	
        	allowing(values).getItemCount();
            will(returnValue(3));

            allowing(values).getKey(0);
            will(returnValue(0));
            allowing(values).getKey(1);
            will(returnValue(1));
            allowing(values).getKey(2);
            will(returnValue(2));

            allowing(values).getValue(0);
            will(returnValue(5));
            allowing(values).getValue(1);
            will(returnValue(9));
            allowing(values).getValue(2);
            will(returnValue(2));
            
        }});

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(values);

        assertEquals(0.3125, cumulativePercentages.getValue(0).doubleValue(), 0.01);
        assertEquals(0.875, cumulativePercentages.getValue(1).doubleValue(), 0.01);
        assertEquals(1.0, cumulativePercentages.getValue(2).doubleValue(), 0.01);
        
    }
	

}
