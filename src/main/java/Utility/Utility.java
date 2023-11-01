package Utility;
import com.fasterxml.jackson.databind.DatabindException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
    public Date dateparser(String date) throws ParseException {
        return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(date).getTime());
    }
    public  boolean isObjectDateValid(Object obj) {
        if (obj == null) {
            return false;
        }
        String dateStr = obj.toString();
        // Define the date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            // Parse the string as a date
            java.util.Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
