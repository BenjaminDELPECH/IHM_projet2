/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_final;

/**
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author benja
 */
public class verifChampsStudent {

    static int verifName(String name) {
        //System.out.println(name.getClass().getName());
        //System.out.println(name);
        
        //System.out.println(name);
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("((\\d)|(^\\s))|(\\s$)|([&~²\"\\(\\)\\{\\}\\[\\]\\|\\+\\*\\/\\#\\_\\@\\%\\€\\$\\£\\¤\\µ\\,\\?\\;\\.\\:\\§\\!])");
        matcher = pattern.matcher(name);

        if (matcher.find()) {
            //System.out.println("ddd");
            return 2;
        } else if (name.length()==0) {
            return 1;
        } else {
            return 0;
        }
    }

    static int verifDateOfBirth(int yearBirth) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        if (yearBirth > year || yearBirth < 1900) {
            return 1;
        } else {
            return 0;
        }
    }
}
