package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class HtmlUtils {
    public static String toCssRgba(int i) {
        double dAlpha = Color.alpha(i);
        Double.isNaN(dAlpha);
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(dAlpha / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return "." + str + ",." + str + " *";
    }
}
