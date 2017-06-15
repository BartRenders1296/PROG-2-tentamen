package app.Enums;

import java.util.Random;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public enum TreeSize {
    S("S"), M("M"), L("L"), XL("XL"), XXL("XXL");

    private String filePrefix;

    TreeSize(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public static TreeSize randomSize() {
        return TreeSize.values()[new Random().nextInt(TreeSize.values().length)];
    }
}
