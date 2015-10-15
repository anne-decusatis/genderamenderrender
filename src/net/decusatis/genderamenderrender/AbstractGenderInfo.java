package net.decusatis.genderamenderrender;

/**
 * Created by anne on 10/15/15.
 */
public abstract class AbstractGenderInfo implements GenderInfo {

    private Utils.Gender determination;

    protected void setGenderDetermination(Utils.Gender g) {
        this.determination = g;
    }

    @Override
    public Utils.Gender getGenderDetermination() {
        return determination;
    }

    @Override
    public boolean getIsFemale() {
        return Utils.getIsFemale(determination);
    }

    @Override
    public boolean getIsMale() {
        return Utils.getIsMale(determination);
    }
}
