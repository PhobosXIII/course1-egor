package com.example.egsha.newtonparkguide;

import java.util.ArrayList;
import java.util.List;

public class ExibitGenerator {
    static private int count = 0;
    static private int numberOfExhibits = 5;
    private static final String[] names = new String[]{"1","2","3","4","5"};
    private static final Exhibit defaultExhibit = new Exhibit("undefined","undefined","");
    private static final String[] images = new String[]{"https://www.prohandmade.ru/wp-content/uploads/2015/09/starwarsiconsawakens-16-900x900.png",
            "http://img.scoop.it/GroGTPKlZ4COVytp24pJdoXXXL4j3HpexhjNOf_P3YmryPKwJ94QGRtDb3Sbc6KY",
            "https://storage.googleapis.com/replit/images/1509526663063_78cee07358a3fd43480ae7fa5b4d76e3.png",
            "https://yt3.ggpht.com/a-/AJLlDp13bM8yFuEE7HVlYHFt7zvZPSMWbGEz4OrxOw=s900-mo-c-c0xffffffff-rj-k-no",
            "http://comic-cons.xyz/wp-content/uploads/Star-Wars-avatar-icon-Ewok.png"};
    private static final String[] descriptions = new String[]{"This is exhibit number 1","This is exhibit number 2","This is exhibit number 3","This is exhibit number 4","This is exhibit number 5"};
    public static List<Exhibit> getExhibits(){
        List<Exhibit> res = new ArrayList<>(numberOfExhibits);
        for(int i = 0;i< numberOfExhibits;i++){
            res.add(new Exhibit(names[i],descriptions[i],images[i]));
        }
        return res;
    }
    public static Exhibit getExhibit(int number){
        if(number < numberOfExhibits){
            return new Exhibit(names[number],descriptions[number],images[number]);
        }else {
            return defaultExhibit;
        }
    }
    public static Exhibit nextExhibit(){
        Exhibit exhibit;
        if(count < numberOfExhibits){
            exhibit = new Exhibit(names[count],descriptions[count],images[count]);
        }else {

            exhibit = defaultExhibit;
        }
        count++;
        return exhibit;
    }
}
