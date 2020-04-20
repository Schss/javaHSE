package Information;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class InformationAboutUser {
    public String Surname;
    public String Initials;
    public char sex;
    public int age;

    public InformationAboutUser(String bInf) throws ParseException {
        String[] inf;
        inf = bInf.split(" ");

        Surname = inf[0];

        Initials = inf[1].charAt(0) + "." + inf[2].charAt(0) + ".";

        char end = inf[2].charAt(inf[2].length()-1);
        if(end == 'а'){
            sex = 'Ж';
        }
        else{
            sex = 'М';
        }

        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime thisDate = LocalDateTime.now();

        LocalDate endDate = LocalDate.parse(inf[3], dateFormat);
        LocalDate startDate = LocalDate.parse((dateFormat.format(thisDate)), dateFormat);
        Period period;
        period = Period.between(endDate, startDate);
        age = period.getYears();
    }

}
