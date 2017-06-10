package app.Enums;

import java.util.Random;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public enum TreeType {
    PINE("pine"), LEAF("leaf");

    private String filePrefix;

    TreeType(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public static TreeType getRandomType() {
        int pick = new Random().nextInt(TreeType.values().length);
        return TreeType.values()[pick];
    }

    public static TreeType getType(String filePrefix){
        return TreeType.valueOf(filePrefix.toUpperCase());
    }
}
