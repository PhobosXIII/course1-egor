package com.example.egsha.newtonparkguide;

import java.util.ArrayList;
import java.util.List;

public class ExhibitGenerator {
    private static final String[] names = new String[]{"Vase", "Mona Lisa", "Emerald Sword", "HAL 9000", "Black Square", "Another Vase"};
    private static final String[] images = new String[]{"https://www.prohandmade.ru/wp-content/uploads/2015/09/starwarsiconsawakens-16-900x900.png",
            "http://img.scoop.it/GroGTPKlZ4COVytp24pJdoXXXL4j3HpexhjNOf_P3YmryPKwJ94QGRtDb3Sbc6KY",
            "https://storage.googleapis.com/replit/images/1509526663063_78cee07358a3fd43480ae7fa5b4d76e3.png",
            "https://yt3.ggpht.com/a-/AJLlDp13bM8yFuEE7HVlYHFt7zvZPSMWbGEz4OrxOw=s900-mo-c-c0xffffffff-rj-k-no",
            "http://comic-cons.xyz/wp-content/uploads/Star-Wars-avatar-icon-Ewok.png",
            "https://storage.googleapis.com/replit/images/1509526663063_78cee07358a3fd43480ae7fa5b4d76e3.png"};
    private static final String[] descriptions = new String[]{"This is exhibit number 1",
            "This is exhibit number 2",
            "This is exhibit number 3",
            "This is exhibit number 4",
            "This is exhibit number 5",
            "This is exhibit number 6"};

    public static List<Exhibit> getExhibits() {
        List<Exhibit> res = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            res.add(new Exhibit(names[i], descriptions[i], images[i]));
        }
        return res;
    }
}
