package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;

/* loaded from: classes7.dex */
public abstract class WL6 {
    public static Layout.Alignment[] a = Layout.Alignment.values();

    public static Layout.Alignment a() {
        Layout.Alignment[] alignmentArr = a;
        return alignmentArr.length >= 5 ? alignmentArr[3] : Layout.Alignment.ALIGN_NORMAL;
    }

    public static Layout.Alignment b() {
        Layout.Alignment[] alignmentArr = a;
        return alignmentArr.length >= 5 ? alignmentArr[4] : Layout.Alignment.ALIGN_OPPOSITE;
    }

    public static StaticLayout c(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i4, int i5, boolean z2) {
        CharSequence charSequenceAppend = charSequence;
        try {
            if (i5 == 1) {
                int iIndexOf = TextUtils.indexOf(charSequenceAppend, Separators.RETURN) - 1;
                if (iIndexOf > 0) {
                    charSequenceAppend = SpannableStringBuilder.valueOf(charSequenceAppend.subSequence(0, iIndexOf)).append((CharSequence) "…");
                }
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(charSequenceAppend, textPaint, i4, TextUtils.TruncateAt.END);
                return new StaticLayout(charSequenceEllipsize, 0, charSequenceEllipsize.length(), textPaint, i3, alignment, f, f2, z);
            }
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(charSequenceAppend, 0, charSequence.length(), textPaint, i3).setAlignment(alignment).setLineSpacing(f2, f).setIncludePad(z).setEllipsize(null).setEllipsizedWidth(i4).setMaxLines(i5).setBreakStrategy(1).setHyphenationFrequency(0).build();
            if (staticLayoutBuild.getLineCount() <= i5) {
                return staticLayoutBuild;
            }
            int i6 = i5 - 1;
            float lineLeft = staticLayoutBuild.getLineLeft(i6);
            float lineWidth = staticLayoutBuild.getLineWidth(i6);
            int offsetForHorizontal = lineLeft != 0.0f ? staticLayoutBuild.getOffsetForHorizontal(i6, lineLeft) : staticLayoutBuild.getOffsetForHorizontal(i6, lineWidth);
            if (lineWidth < i4 - AbstractC21455b.F(10.0f)) {
                offsetForHorizontal += 3;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceAppend.subSequence(0, Math.max(0, offsetForHorizontal - 3)));
            spannableStringBuilder.append((CharSequence) "…");
            return StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), textPaint, i3).setAlignment(alignment).setLineSpacing(f2, f).setIncludePad(z).setEllipsize(((AnimatedEmojiSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AnimatedEmojiSpan.class)).length > 0 ? null : truncateAt).setEllipsizedWidth(i4).setMaxLines(i5).setBreakStrategy(z2 ? 1 : 0).setHyphenationFrequency(0).build();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return null;
        }
    }
}
