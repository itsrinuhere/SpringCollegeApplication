package Utility;
import java.time.Year;
public class Utility {
    public String UUIDGenerator(){
        return "";
    }
    public boolean isYearFormat(String input) {
        return Integer.parseInt(input.substring(0, 4)) >= 1980 && Integer.parseInt(input.substring(5, 9)) <= Year.now().getValue();
    }
}
