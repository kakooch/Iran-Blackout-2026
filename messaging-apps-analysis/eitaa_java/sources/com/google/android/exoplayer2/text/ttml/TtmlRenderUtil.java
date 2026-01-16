package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

/* loaded from: classes.dex */
final class TtmlRenderUtil {
    public static TtmlStyle resolveStyle(TtmlStyle style, String[] styleIds, Map<String, TtmlStyle> globalStyles) {
        if (style == null && styleIds == null) {
            return null;
        }
        int i = 0;
        if (style == null && styleIds.length == 1) {
            return globalStyles.get(styleIds[0]);
        }
        if (style == null && styleIds.length > 1) {
            TtmlStyle ttmlStyle = new TtmlStyle();
            int length = styleIds.length;
            while (i < length) {
                ttmlStyle.chain(globalStyles.get(styleIds[i]));
                i++;
            }
            return ttmlStyle;
        }
        if (style != null && styleIds != null && styleIds.length == 1) {
            return style.chain(globalStyles.get(styleIds[0]));
        }
        if (style != null && styleIds != null && styleIds.length > 1) {
            int length2 = styleIds.length;
            while (i < length2) {
                style.chain(globalStyles.get(styleIds[i]));
                i++;
            }
        }
        return style;
    }

    public static void applyStylesToSpan(SpannableStringBuilder builder, int start, int end, TtmlStyle style) {
        if (style.getStyle() != -1) {
            builder.setSpan(new StyleSpan(style.getStyle()), start, end, 33);
        }
        if (style.isLinethrough()) {
            builder.setSpan(new StrikethroughSpan(), start, end, 33);
        }
        if (style.isUnderline()) {
            builder.setSpan(new UnderlineSpan(), start, end, 33);
        }
        if (style.hasFontColor()) {
            builder.setSpan(new ForegroundColorSpan(style.getFontColor()), start, end, 33);
        }
        if (style.hasBackgroundColor()) {
            builder.setSpan(new BackgroundColorSpan(style.getBackgroundColor()), start, end, 33);
        }
        if (style.getFontFamily() != null) {
            builder.setSpan(new TypefaceSpan(style.getFontFamily()), start, end, 33);
        }
        if (style.getTextAlign() != null) {
            builder.setSpan(new AlignmentSpan.Standard(style.getTextAlign()), start, end, 33);
        }
        int fontSizeUnit = style.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            builder.setSpan(new AbsoluteSizeSpan((int) style.getFontSize(), true), start, end, 33);
        } else if (fontSizeUnit == 2) {
            builder.setSpan(new RelativeSizeSpan(style.getFontSize()), start, end, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            builder.setSpan(new RelativeSizeSpan(style.getFontSize() / 100.0f), start, end, 33);
        }
    }

    static void endParagraph(SpannableStringBuilder builder) {
        int length = builder.length() - 1;
        while (length >= 0 && builder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || builder.charAt(length) == '\n') {
            return;
        }
        builder.append('\n');
    }

    static String applyTextElementSpacePolicy(String in) {
        return in.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}
