package Utility;
import java.time.Year;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public String UUIDGenerator(){
        return UUID.randomUUID().toString();
    }
    public boolean isYearFormat(String input) {
        return Integer.parseInt(input.substring(0, 4)) >= 1980 && Integer.parseInt(input.substring(5, 9)) <= Year.now().getValue();
    }
    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
