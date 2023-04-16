import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VINValidatorTestt {
    @Test
    public void testisVINFormatCorrect(){
        var VIN = new VINValidator();
        assertTrue(VIN.isVINFormatCorrect("0471958692"));
        assertFalse(VIN.isVINFormatCorrect("123"));
        assertFalse(VIN.isVINFormatCorrect("047195869A"));

    }
    @Test
    public void testisVINCheckDigitValid(){
        var VIN = new VINValidator();
        assertTrue(VIN.isVINCheckDigitValid("0471958692"));
        assertFalse(VIN.isVINCheckDigitValid("0471958699"));
        assertTrue(VIN.isVINCheckDigitValid("0471606958"));
        assertFalse(VIN.isVINCheckDigitValid("0471958696"));

    }
    @Test
    public void testValidVIN() {
        var VIN = new VINValidator();
        assertFalse(VIN.isVINValid("0471606958"));
        assertFalse(VIN.isVINValid("047195869b"));
        assertTrue(VIN.isVINValid("047195869-2"));
        assertTrue(VIN.isVINValid("047160695-8"));
        assertFalse(VIN.isVINValid("012345613-8"));
    }

    @Test
    public void testInvalidVIN() {
        var VIN = new VINValidator();
        assertFalse(VIN.isVINValid("0471958691"));
        assertFalse(VIN.isVINValid("A12345678"));
    }

}