package com.example.mustafamotiwala.tindergiphy.Utils;

public class ImageUtils {

    public static int[] getScaledSizeValues(String width, String height, float scale) {
        int gifWidth = Integer.valueOf(width);
        int gifHeight = Integer.valueOf(height);
        int dpWidthInPx  = (int) (gifWidth * scale);
        int dpHeightInPx = (int) (gifHeight * scale);
        int[] values = new int[2];
        values[0] = dpWidthInPx;
        values[1] = dpHeightInPx;
        return values;

    }

}
