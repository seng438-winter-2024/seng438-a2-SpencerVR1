package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.junit.Test;

import org.jmock.*;

public class DataUtilities345Test extends DataUtilities {
	
	
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