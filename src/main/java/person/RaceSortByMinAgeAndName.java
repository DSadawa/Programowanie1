package person;

import java.util.Comparator;

public class RaceSortByMinAgeAndName implements Comparator<Race> {

    @Override
    public int compare(Race o1, Race o2) {
        if (o1.getMinimalAge() - o2.getMinimalAge() !=0)
        return o1.getMinimalAge() - o2.getMinimalAge();
        return o1.getRaceName().compareTo(o2.getRaceName());
    }
}
