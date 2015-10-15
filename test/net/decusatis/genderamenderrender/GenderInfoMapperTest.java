package net.decusatis.genderamenderrender;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by anne on 10/15/15.
 */
public class GenderInfoMapperTest {

    @Test
    public void selectNoneIsUnspecified(){
        String[] genders = {};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertEquals(Utils.Gender.UNSPECIFIED, gim.getGenderDetermination());
    }

    @Test
    public void onlySelectMaleIsMale(){
        String[] genders = {"male"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertTrue(gim.getIsMale());
    }

    @Test
    public void onlySelectFemaleIsFemale(){
        String[] genders = {"female"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertTrue(gim.getIsFemale());
    }

    @Test
    public void onlySelectNonbinaryIsNonbinary(){
        String[] genders = {"?"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertEquals(Utils.Gender.NONBINARY, gim.getGenderDetermination());
    }

    @Test
    public void selectDeclineAndOthersDecline(){
        String[] genders = {"?", "decline to provide", "male"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertEquals(Utils.Gender.DECLINE, gim.getGenderDetermination());
    }

    @Test
    public void selectMultipleTypesOfWordsUnsure(){
        String[] genders = {"male", "female"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertEquals(Utils.Gender.UNSURE, gim.getGenderDetermination());
    }

    @Test
    public void selectModifiersStillFemale(){
        String[] genders = {"female", "trans"};
        GenderInfoMapper gim = new GenderInfoMapper(genders);
        assertTrue(gim.getIsFemale());
    }
}
