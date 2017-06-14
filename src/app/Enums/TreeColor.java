package app.Enums;

import javafx.scene.paint.Color;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public enum TreeColor {
    ONE(Color.rgb(0, 255, 0)),
    TWO(Color.rgb(0, 210, 0)),
    THREE(Color.rgb(0, 165, 0)),
    FOUR(Color.rgb(0, 120, 0)),
    FIVE(Color.rgb(0, 75, 0)),
    SIX(Color.rgb(30, 200, 80)),
    SEVEN(Color.rgb(30, 170, 80)),
    EIGHT(Color.rgb(30, 140, 80)),
    NINE(Color.rgb(30, 110, 80)),
    TEN(Color.rgb(30, 80, 80));

    private Color color;

    TreeColor(Color color) {
        this.color = color;
    }

    public static TreeColor getColor(TreeType treeType, TreeSize treeSize) {
        if (treeType == TreeType.LEAF) {
            switch (treeSize) {
                case S:
                    return ONE;
                case M:
                    return TWO;
                case L:
                    return THREE;
                case XL:
                    return FOUR;
                case XXL:
                    return FIVE;
            }
        } else {
            switch (treeSize) {
                case S:
                    return SIX;
                case M:
                    return SEVEN;
                case L:
                    return EIGHT;
                case XL:
                    return NINE;
                case XXL:
                    return TEN;
            }
        }
        return null;
    }

    public Color getColor() {
        return color;
    }
}
