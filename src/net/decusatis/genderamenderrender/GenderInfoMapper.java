package net.decusatis.genderamenderrender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by anne on 10/15/15.
 */
public class GenderInfoMapper extends AbstractGenderInfo {

    private List<String> genders; //raw info from json

    public GenderInfoMapper(String[] genders) {
        this.genders = new ArrayList<>(genders.length);
        for (String g : genders) {
            this.genders.add(g);
        }

        this.setGenderDetermination(Utils.renderGenderEnglish(this.genders));
    }

    public Collection<String> getUserSelectedGenders() {
        return genders;
    }
}
