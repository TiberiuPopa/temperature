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
	
	
	// Simple test; no conversion is made, so the units should not change.
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
	
	
	// Initial tests; if no conversion is made, the value should not change.
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
	// It should be ensured that the program responds correctly to this particularly special illegal input.
	@Test
	public void testGetValueCelsiusSubZero() {
		Temperature tester = new Temperature(-300.0, Temperature.Units.CELSIUS);
		assertEquals("*getValue() returns wrong value for sub-0 Celsius!*", -273.15, tester.getValue(), 0.000001);
										// Absolute Zero in C is -273.15
	}
	
	@Test
	public void testGetValueFahrenheitSubZero() {
		Temperature tester = new Temperature(-600.0, Temperature.Units.FAHRENHEIT);
		assertEquals("*getValue() returns wrong value for sub-0 Fahrenheit!*", -459.67, tester.getValue(), 0.000001);
										// Absolute Zero in F is -459.67
	}
	
	@Test
	public void testGetValueKelvinSubZero() {
		Temperature tester = new Temperature(-10.0, Temperature.Units.KELVIN);
		assertEquals("*getValue() returns wrong value for sub-0 Kelvin!*", 0.0, tester.getValue(), 0.000001);
										// Absolute Zero in K is 0.0
	}
	
	
	// ***End of tests for getValue()***
	
	
	
	// ***Start of tests for changeUnits(), input being in Celsius***
	
	
	// Testing Celsius to Celsius. Special case; should not crash.
	@Test
	public void celToCel() {
		Temperature tester = new Temperature(100.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure C->C!*", 100.0, tester.getValue(), 0.000001);
	}
		
	// Testing positive Celsius to Kelvin
	@Test
	public void celsiusPosKelvin() {
		Temperature tester = new Temperature(10.15, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure C->K!*", 283.30, tester.getValue(), 0.000001);
	}
	
	// Testing zero Celsius to Kelvin. Making sure no division by 0 occurs.
	@Test
	public void celsiusZeroKelvin() {
		Temperature tester = new Temperature(0.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure C->K!*", 273.15, tester.getValue(), 0.000001);
	}
	
	// Testing negative Celsius to Kelvin. Making sure there are no sign errors.
	@Test
	public void celsiusNegKelvin() {
		Temperature tester = new Temperature(-10.15, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure C->K!*", 263.0, tester.getValue(), 0.000001);
	}
	
	// Testing positive Celsius to Fahrenheit
	@Test
	public void celsiusPosFahrenheit() {
		Temperature tester = new Temperature(45.6, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure C->F!*", 114.08, tester.getValue(), 0.000001);
	}
	
	// Testing zero Celsius to Fahrenheit. Making sure no division by 0 occurs.
	@Test
	public void celsiusZeroFahrenheit() {
		Temperature tester = new Temperature(0.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure C->F!*", 32.0, tester.getValue(), 0.000001);
	}
	
	// Testing negative Celsius to positive Fahrenheit. Making sure there are no sign errors.
	@Test
	public void celsiusNegFahrenheit() {
		Temperature tester = new Temperature(-5.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure C->F!*", 23.0, tester.getValue(), 0.000001);
	}
	
	
	// No need to check for positive Celsius to negative Fahrenheit because it's impossible. 
	
	
	// Testing -40 Celsius to Fahrenheit. It gives -40 as well, it's just a particular case to check.
	// This also covers negative Celsius to negative Farhenheit.
	@Test
	public void celsiusFortyFarhenheit() {
		Temperature tester = new Temperature(-40.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure C->F!*", -40.0, tester.getValue(), 0.000001);
	}
	
	// Testing Celsius to Fahrenheit - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void celFahrenheitSubZero() {
		Temperature tester = new Temperature(-500.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure C->F sub-0!*", -459.67, tester.getValue(), 0.000001);
	}
	
	// Testing Celsius to Kelvin - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void celKelvinSubZero() {
		Temperature tester = new Temperature(-500.0, Temperature.Units.CELSIUS);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure C->K sub-0!*", 0.0, tester.getValue(), 0.000001);
	}
	
	
	
	// ***Start of tests for changeUnits(), input being in Fahrenheit***
	
	
	// Testing Fahrenheit to Fahrenheit. Special case; should not crash.
	@Test
	public void fahToFah() {
		Temperature tester = new Temperature(100.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure F->F!*", 100.0, tester.getValue(), 0.000001);
	}
		
	// Testing positive Fahrenheit to Celsius
	@Test
	public void fahPosCelsius() {
		Temperature tester = new Temperature(60.8, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C!*", 16.0, tester.getValue(), 0.000001);
	}
	
	// Testing zero Fahrenheit to Celsius. Making sure no division by 0 occurs.
	// Checks for endless fractions. Here, the answer is 17.777777... we stop at the 6th zero as per prof.'s wish
	@Test
	public void fahZeroCelsius() {
		Temperature tester = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C!*", -17.777777, tester.getValue(), 0.000001);
	}
	
	// Testing negative Fahrenheit to Celsius. Making sure there are no sign errors.
	@Test
	public void fahNegCelsius() {
		Temperature tester = new Temperature(-10.2, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C!*", -23.444444, tester.getValue(), 0.000001);
	}
	
	// Testing -40 Fahrenheit to Celsius. It gives -40 as well, it's just a particular case to check.
	// This also covers negative Farhenheit to negative Celsius.
	@Test
	public void fahFortyCelsius() {
		Temperature tester = new Temperature(-40.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C!*", -40.0, tester.getValue(), 0.000001);
	}
	
	// Testing positive Fahrenheit to Kelvin
	@Test
	public void fahPosKelvin() {
		Temperature tester = new Temperature(2.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure F->K!*", 256.483333, tester.getValue(), 0.000001);
	}
	
	// Testing zero Fahrenheit to Kelvin. Making sure no division by 0 occurs.
	@Test
	public void fahZeroKelvin() {
		Temperature tester = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure F->K!*", 255.372223, tester.getValue(), 0.000001);
	}
	
	// Testing negative Fahrenheit to Kelvin. Making sure there are no sign errors.
	@Test
	public void fahNegKelvin() {
		Temperature tester = new Temperature(-2.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure F->K!*", 254.261111, tester.getValue(), 0.000001);
	}
	
	// Testing Fahrenheit to Celsius - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void fahCelsiusSubZero() {
		Temperature tester = new Temperature(-500.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C sub-0!*", -273.15, tester.getValue(), 0.000001);
	}
	
	// Testing Fahrenheit to Kelvin - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void fahKelvinSubZero() {
		Temperature tester = new Temperature(-500.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure F->K sub-0!*", 0.0, tester.getValue(), 0.000001);
	}
	
	
	
	// ***Start of tests for changeUnits(), input being in Kelvin***
	
	
	// Testing Kelvin to Kelvin. Special case; should not crash.
	@Test
	public void kelToKel() {
		Temperature tester = new Temperature(100.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.KELVIN);
		assertEquals("*changeUnits() failure K->K!*", 100.0, tester.getValue(), 0.000001);
	}
	
	// Testing Kelvin to positive Celsius
	@Test
	public void kelPosCelsius() {
		Temperature tester = new Temperature(400.15, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure K->C!*", 127.0, tester.getValue(), 0.000001);
	}
	
	// Testing 0 Kelvin to Celsius.  Making sure no division by 0 occurs.
	@Test
	public void kelZeroCelsius() {
		Temperature tester = new Temperature(0.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure K->C!*", -273.15, tester.getValue(), 0.000001);
	}
	
	// Testing Kelvin to negative Celsius. Making sure there are no sign errors.
	@Test
	public void kelNegCelsius() {
		Temperature tester = new Temperature(5.55, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure K->C!*", -267.6, tester.getValue(), 0.000001);
	}	
	
	// Testing Kelvin to positive Fahrenheit
	@Test
	public void kelPosFahrenheit() {
		Temperature tester = new Temperature(5000.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure K->F!*", 8540.33, tester.getValue(), 0.000001);
	}
	
	// Testing zero Kelvin to Fahrenheit. Making sure no division by 0 occurs.
	@Test
	public void kelZeroFahrenheit() {
		Temperature tester = new Temperature(0.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure K->F!*", -459.67, tester.getValue(), 0.000001);
	}
	
	// Testing Kelvin to negative Fahrenheit. Making sure there are no sign errors.
	@Test
	public void kelNegFahrenheit() {
		Temperature tester = new Temperature(0.001, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure K->F!*", -459.6682, tester.getValue(), 0.000001);
	}
	
	// Testing Kelvin to Celsius - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void kelCelsiusSubZero() {
		Temperature tester = new Temperature(-1.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure K->C sub-0!*", -273.15, tester.getValue(), 0.000001);
	}
	
	// Testing Kelvin to Fahrenheit - sub Absolute Zero. Should return Absolute Zero.
	@Test
	public void kelFahrenheitSubZero() {
		Temperature tester = new Temperature(-1000.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure K->F sub-0!*", -459.67, tester.getValue(), 0.000001);
	}
	
	
	
	// ***Misc. tests***
	
	
	// Testing for very large values. Should not overflow (at least not for reasonable temperatures)
	@Test
	public void kelLarge() {
		Temperature tester = new Temperature(1000000000.0, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("*changeUnits() failure K->F for large values!*", 1799999540.330000, tester.getValue(), 0.000001);
	}
	
	// Testing for very large values again. This time Celsius to Fahrenheit, which triggers 2 conversions in the code.
	@Test
	public void fahToCelLarge() {
		Temperature tester = new Temperature(1000000000.0, Temperature.Units.FAHRENHEIT);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure F->C for large values!*", 555555537.777777, tester.getValue(), 0.000001);
	}
	
	// Testing for very small values. Should still be accurate to 6 digits.
	@Test
	public void kelSmall() {
		Temperature tester = new Temperature(0.000001, Temperature.Units.KELVIN);
		tester.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("*changeUnits() failure K->C for small values!*", -273.149999, tester.getValue(), 0.000001);
	}
	
}
