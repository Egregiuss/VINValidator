public class VINValidator {
    // Check if VIN is in correct format
    public static boolean isVINFormatCorrect(String vin) {
      // Check if string is null or empty
      if (vin == null || vin.isEmpty()){
          return false;
      }
      //check if string contains only digits and has length of 10
        return vin.matches("\\d{10}");
    }
    //Validate check digit of VIN number
    public static boolean isVINCheckDigitValid(String vin){
        //Check if VIN is in correct format
        if (!isVINFormatCorrect(vin)) {
            return  false;
        }
        // Calculate the check digit
        int sum = 0;
        for (int i = 0;  i<9; i++){
            sum += (i  * Integer.parseInt(vin.substring(i,i+1)));
        }
        int checkDigit = sum % 11;
        // Check if the check digit checks out
        if (checkDigit ==10) {
            return vin.substring(9).equalsIgnoreCase("X");
        }else {
            return checkDigit == Integer.parseInt(vin.substring(9));
        }

    }
    // Validate VIN with before check digit
    public static boolean isVINValid(String vin) {
        if (vin == null || vin.isEmpty()) {
            return false;
        }
        if (!vin.matches("\\d{9}[-]\\d")) {
            return false;
        }
        //Remove hyphen from VIN
        String vinWithoutHyphen = vin.replace("-","");
        return isVINCheckDigitValid(vinWithoutHyphen);
    }
}
