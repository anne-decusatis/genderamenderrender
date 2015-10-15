package net.decusatis.genderamenderrender;

import java.util.Collection;

/**
 * Created by anne on 10/15/15.
 */
public interface GenderInfo {

    Collection<String> getUserSelectedGenders();

    // for convenience/legacy systems that only take into account m and f
    boolean getIsMale();
    boolean getIsFemale();

    Utils.Gender getGenderDetermination();
}
