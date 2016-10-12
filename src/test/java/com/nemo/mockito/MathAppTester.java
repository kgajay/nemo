package com.nemo.mockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * @author ajay.kg created on 12/10/16.
 */
@Test(suiteName = "MathAppTester")
public class MathAppTester {


	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	//@Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@BeforeMethod(alwaysRun=true)
	public void injectDoubles() {
		MockitoAnnotations.initMocks(this); //This could be pulled up into a shared base class
//		mathApplication = new MathApplication();
//		calcService = mock(CalculatorService.class);
//		mathApplication.setCalculatorService(calcService);
	}

	@Test
	public void testAdd(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(40.00);

		//test the add functionality
		assertEquals(mathApplication.add(10.0, 20.0), 40.0, 0);
		verify(calcService).add(10.0, 20.0);
	}
}
