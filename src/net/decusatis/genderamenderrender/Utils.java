package net.decusatis.genderamenderrender;

import java.util.Collection;

/**
 * Created by anne on 10/15/15.
 */
public class Utils {

    /**
     * The options we're working with (for now)
     */
    public enum Gender {
        MALE,
        FEMALE,
        NONBINARY, // non-male or female genders go in this bucket for now
        DECLINE, // they've selected they don't want to provide this
        UNSURE, // they've selected something we can't parse to m, f, or neither
        UNSPECIFIED // they haven't selected something
    }


    /**
     * Business logic to transform a collection of strings to a gender enum item
     */

    public static Gender renderGenderEnglish(Collection<String> selections) {

        // unspecified
        if (selections == null || selections.isEmpty()){
            return Gender.UNSPECIFIED;
        }


        // these booleans are set up throughout this method, and their combination determines the value we return
        boolean male = false;
        boolean female = false;
        boolean nonbinary = false;
        boolean decline = false;


        for (String elt : selections) {
             switch (elt) {
                 // decline to provide setup
                 case "decline to provide":
                 case "prefer not to say":
                     decline = true;
                     break;
                 // male setup
                 case "f to m":
                 case "female to male":
                 case "male":
                 case "man":
                 case "transmasculine":
                     male = true;
                     break;
                 // female setup
                 case "female":
                 case "femme":
                 case "m to f":
                 case "male to female":
                 case "transfeminine":
                 case "woman":
                     female = true;
                     break;
                 // nonbinary setup
                 case "?":
                 case "agender":
                 case "bigender":
                 case "gender nonconforming":
                 case "gender questioning":
                 case "gender variant":
                 case "genderfluid":
                 case "genderqueer":
                 case "neither":
                 case "neutrois":
                 case "nonbinary":
                 case "none":
                 case "other":
                 case "pangender":
                 case "polygender":
                 case "questioning":
                 case "two spirit":
                     nonbinary = true;
                     break;
                 default: // words like "trans" which don't denote anything about m/f/nb status
                     break;
             }
        }

        // determination
        if(decline) {
            return Gender.DECLINE; // if they decline to provide it doesn't matter what else they said, we don't use it
        }
        // if they're clearly selecting only male, only female, or only neither male nor female options, assign as such
        else if (male && !female && !nonbinary) {
            return Gender.MALE;
        } else if (female && !male && !nonbinary) {
            return Gender.FEMALE;
        } else if (nonbinary && !male && !female) {
            return Gender.NONBINARY;
        }
        // otherwise, let's not do anything clever for now
        else {
            return Gender.UNSURE;
        }

    }

    /**
     * Helper methods
     */
    public static boolean getIsMale(Gender g) {
        return Gender.MALE == g;
    }
    public static boolean getIsFemale(Gender g) {
        return Gender.FEMALE == g;
    }
}
