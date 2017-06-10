package app.Enums;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public enum TreeSize {
    //S(45, 25, 5), M(85, 50, 7), L(120, 80, 10), XL(165, 110, 15), XXL(200, 130, 20);
    S("S", 45, 25, 5), M("M", 85, 50, 7), L("L", 120, 80, 10), XL("XL", 165, 110, 15), XXL("XXL", 200, 130, 20);

    private int totalHeight;
    private int leafSize;
    private int trunkWidth;
    private int trunkHeight;
    private String filePrefix;

    TreeSize(String filePrefix, int totalHeight, int leafSize, int trunkWidth) {
        this.totalHeight = (int) (totalHeight * 0.50);
        this.leafSize = (int) (leafSize * 0.50);
        this.trunkWidth = (int) (trunkWidth * 0.50);
        this.trunkHeight = totalHeight - leafSize;
        this.filePrefix = filePrefix;
    }

    public int getTotalHeight() {
        return totalHeight;
    }

    public int getLeafSize() {
        return leafSize;
    }

    public int getTrunkWidth() {
        return trunkWidth;
    }

    public int getTrunkHeight() {
        return trunkHeight;
    }

    public String getFilePrefix() {
        return filePrefix;
    }
}
