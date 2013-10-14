/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {
	
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
	
}
