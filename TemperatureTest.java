/** 
 * @author Tiberiu Popa (tiberiu.popa@mail.mcgill.ca)
 * ID : 260414246
 * @version 2013.10.13
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {

	
	// ***Start of tests for getUnits()***
	
	
	@Test
	public void testGetUnitsCelsius() {
		Temperature tester = new Temperature(10.0, Temperature.Units.CELSIUS);	// The 10.0 is irrelevant; we test units
		assertTrue("*getUnits() fails for Celsius!*", Temperature.Units.CELSIUS == tester.getUnits() );
	}
	
	@Test
	public void testGetUnitsFahrenheit() {
		Temperature tester = new Temperature(10.0, Temperature.Units.FAHRENHEIT);
		assertTrue("*getUnits() fails for Fahrenheit!*", Temperature.Units.FAHRENHEIT == tester.getUnits() );
	}
	
	@Test
	public void testGetUnitsKelvin() {
		Temperature tester = new Temperature(10.0, Temperature.Units.KELVIN);
		assertTrue("*getUnits() fails for Kelvin!*", Temperature.Units.KELVIN == tester.getUnits() );
	}
	
	
	// ***End of tests for getUnits()***
	
	
	
	// ***Start of tests for getValue()***
	
	
	@Test
	public void testGetValueCelsius() {
		Temperature tester = new Temperature(10.0, Temperature.Units.CELSIUS);
		assertEquals("*getValue() returns wrong value for Celsius!*", 10.0, tester.getValue(), 0.000001);
		// Using tolerance=0.000001 because prof. mentioned 1e6 precision on discussion board
	}
	
	@Test
	public void testGetValueFahrenheit() {
		Temperature tester = new Temperature(10.0, Temperature.Units.FAHRENHEIT);
		assertEquals("*getValue() returns wrong value for Fahrenheit!*", 10.0, tester.getValue(), 0.000001);
	}
	
	@Test
	public void testGetValueKelvin() {
		Temperature tester = new Temperature(10.0, Temperature.Units.KELVIN);
		assertEquals("*getValue() returns wrong value for Kelvin!*", 10.0, tester.getValue(), 0.000001);
	}
	
	
	
	// Testing for temperatures below the absolute zero, for all 3 units.
	// Temperature.java was changed! In this case, the absolute zero is returned!
	@Test
	public void testGetValueCelsiusSubZero() {
		Temperature tester = new Temperature(-300.0, Temperature.Units.CELSIUS);
		assertEquals("*getValue() returns wrong value for Celsius!*", -273.15, tester.getValue(), 0.000001);
									// Absolute Zero in C is -273.15
	}
	
	@Test
	public void testGetValueFahrenheitSubZero() {
		Temperature tester = new Temperature(-600.0, Temperature.Units.FAHRENHEIT);
		assertEquals("*getValue() returns wrong value for Fahrenheit!*", -459.67, tester.getValue(), 0.000001);
									// Absolute Zero in F is -459.67
	}
	
	@Test
	public void testGetValueKelvinSubZero() {
		Temperature tester = new Temperature(-10.0, Temperature.Units.KELVIN);
		assertEquals("*getValue() returns wrong value for Kelvin!*", 0.0, tester.getValue(), 0.000001);
									// Absolute Zero in K is 0.0
	}
	
	
	// ***End of tests for getValue()***
	
}
