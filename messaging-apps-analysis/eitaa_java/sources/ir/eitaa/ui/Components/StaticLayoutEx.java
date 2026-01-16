package ir.eitaa.ui.Components;

import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;

/* loaded from: classes3.dex */
public class StaticLayoutEx {
    public static Layout.Alignment[] alignments = Layout.Alignment.values();

    public static Layout.Alignment ALIGN_RIGHT() {
        Layout.Alignment[] alignmentArr = alignments;
        return alignmentArr.length >= 5 ? alignmentArr[4] : Layout.Alignment.ALIGN_OPPOSITE;
    }

    public static Layout.Alignment ALIGN_LEFT() {
        Layout.Alignment[] alignmentArr = alignments;
        return alignmentArr.length >= 5 ? alignmentArr[3] : Layout.Alignment.ALIGN_NORMAL;
    }

    public static StaticLayout createStaticLayout2(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines) {
        if (Build.VERSION.SDK_INT >= 23) {
            return StaticLayout.Builder.obtain(source, 0, source.length(), paint, ellipsisWidth).setAlignment(align).setLineSpacing(spacingadd, spacingmult).setIncludePad(includepad).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(ellipsisWidth).setMaxLines(maxLines).setBreakStrategy(1).setHyphenationFrequency(0).build();
        }
        return createStaticLayout(source, 0, source.length(), paint, width, align, spacingmult, spacingadd, includepad, ellipsize, ellipsisWidth, maxLines, true);
    }

    public static StaticLayout createStaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines) {
        return createStaticLayout(source, 0, source.length(), paint, width, align, spacingmult, spacingadd, includepad, ellipsize, ellipsisWidth, maxLines, true);
    }

    public static StaticLayout createStaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines, boolean canContainUrl) {
        return createStaticLayout(source, 0, source.length(), paint, width, align, spacingmult, spacingadd, includepad, ellipsize, ellipsisWidth, maxLines, canContainUrl);
    }

    public static StaticLayout createStaticLayout(CharSequence source, int bufstart, int bufend, TextPaint paint, int outerWidth, Layout.Alignment align, float spacingMult, float spacingAdd, boolean includePad, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines, boolean canContainUrl) {
        StaticLayout staticLayout;
        int i;
        int i2;
        StaticLayout staticLayout2;
        int offsetForHorizontal;
        try {
            if (maxLines == 1) {
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(source, paint, ellipsisWidth, TextUtils.TruncateAt.END);
                try {
                    return new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), paint, outerWidth, align, spacingMult, spacingAdd, includePad);
                } catch (Exception e) {
                    e = e;
                    staticLayout = null;
                }
            } else {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 23) {
                    staticLayout2 = StaticLayout.Builder.obtain(source, 0, source.length(), paint, outerWidth).setAlignment(align).setLineSpacing(spacingAdd, spacingMult).setIncludePad(includePad).setEllipsize(null).setEllipsizedWidth(ellipsisWidth).setMaxLines(maxLines).setBreakStrategy(1).setHyphenationFrequency(0).build();
                    i = i3;
                    i2 = maxLines;
                } else {
                    i = i3;
                    staticLayout = null;
                    i2 = maxLines;
                    try {
                        staticLayout2 = new StaticLayout(source, paint, outerWidth, align, spacingMult, spacingAdd, includePad);
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (staticLayout2.getLineCount() <= i2) {
                    return staticLayout2;
                }
                int i4 = i2 - 1;
                float lineLeft = staticLayout2.getLineLeft(i4);
                float lineWidth = staticLayout2.getLineWidth(i4);
                if (lineLeft != 0.0f) {
                    offsetForHorizontal = staticLayout2.getOffsetForHorizontal(i4, lineLeft);
                } else {
                    offsetForHorizontal = staticLayout2.getOffsetForHorizontal(i4, lineWidth);
                }
                if (lineWidth < ellipsisWidth - AndroidUtilities.dp(10.0f)) {
                    offsetForHorizontal += 3;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(source.subSequence(0, Math.max(0, offsetForHorizontal - 3)));
                spannableStringBuilder.append((CharSequence) "…");
                if (i >= 23) {
                    return StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), paint, outerWidth).setAlignment(align).setLineSpacing(spacingAdd, spacingMult).setIncludePad(includePad).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(ellipsisWidth).setMaxLines(i2).setBreakStrategy(canContainUrl ? 1 : 0).setHyphenationFrequency(0).build();
                }
                return new StaticLayout(spannableStringBuilder, paint, outerWidth, align, spacingMult, spacingAdd, includePad);
            }
        } catch (Exception e3) {
            e = e3;
            staticLayout = null;
        }
        FileLog.e(e);
        return staticLayout;
    }
}
