package ir.eitaa.ui.Components;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes3.dex */
public class CodepointsLengthInputFilter implements InputFilter {
    private final int mMax;

    public CodepointsLengthInputFilter(int max) {
        this.mMax = max;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int iCodePointCount = this.mMax - (Character.codePointCount(dest, 0, dest.length()) - Character.codePointCount(dest, dstart, dend));
        if (iCodePointCount <= 0) {
            return "";
        }
        if (iCodePointCount >= Character.codePointCount(source, start, end)) {
            return null;
        }
        int i = iCodePointCount + start;
        return (Character.isHighSurrogate(source.charAt(i + (-1))) && (i = i + (-1)) == start) ? "" : source.subSequence(start, i);
    }
}
