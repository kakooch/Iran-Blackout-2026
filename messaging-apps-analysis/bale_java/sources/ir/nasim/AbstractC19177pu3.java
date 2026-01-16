package ir.nasim;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.pu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19177pu3 {
    private static final boolean a = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(float f, CharSequence charSequence, TextPaint textPaint) {
        if (f != 0.0f) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (!AbstractC18227oI6.a(spanned, C7966Ty3.class) && !AbstractC18227oI6.a(spanned, C7727Sy3.class)) {
                }
                return true;
            }
            if (textPaint.getLetterSpacing() != 0.0f) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return charSequence;
        }
        Spanned spanned = (Spanned) charSequence;
        if (!AbstractC18227oI6.a(spanned, CharacterStyle.class)) {
            return charSequence;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, charSequence.length(), CharacterStyle.class);
        if (characterStyleArr == null || characterStyleArr.length == 0) {
            return charSequence;
        }
        SpannableString spannableString = null;
        for (CharacterStyle characterStyle : characterStyleArr) {
            if (!(characterStyle instanceof MetricAffectingSpan)) {
                if (spannableString == null) {
                    spannableString = new SpannableString(charSequence);
                }
                spannableString.removeSpan(characterStyle);
            }
        }
        return spannableString != null ? spannableString : charSequence;
    }
}
