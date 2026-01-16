package org.rbmain.ui.Components;

import android.text.InputFilter;
import android.text.Spanned;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes5.dex */
public class CodepointsLengthInputFilter implements InputFilter {
    private final int mMax;

    public CodepointsLengthInputFilter(int i) {
        this.mMax = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int iCodePointCount = this.mMax - (Character.codePointCount(spanned, 0, spanned.length()) - Character.codePointCount(spanned, i3, i4));
        if (iCodePointCount <= 0) {
            return BuildConfig.FLAVOR;
        }
        if (iCodePointCount >= Character.codePointCount(charSequence, i, i2)) {
            return null;
        }
        int i5 = iCodePointCount + i;
        return (Character.isHighSurrogate(charSequence.charAt(i5 + (-1))) && (i5 = i5 + (-1)) == i) ? BuildConfig.FLAVOR : charSequence.subSequence(i, i5);
    }
}
