package app.Enums;

import java.util.Random;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public enum TreeType {
    PINE, LEAF;

    public static TreeType getRandomType() {
        int pick = new Random().nextInt(TreeType.values().length);
        return TreeType.values()[pick];
    }
}
