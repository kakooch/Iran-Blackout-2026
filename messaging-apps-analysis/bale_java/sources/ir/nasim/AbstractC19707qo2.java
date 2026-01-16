package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;

/* renamed from: ir.nasim.qo2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19707qo2 {
    private static SpannableStringBuilder[] a = new SpannableStringBuilder[3];

    public static CharSequence a(C10743c74 c10743c74, boolean z, int i) {
        return b(c10743c74, z, i, null);
    }

    public static CharSequence b(C10743c74 c10743c74, boolean z, int i, TextPaint textPaint) {
        int i2;
        if (c10743c74 == null) {
            return "";
        }
        SpannableStringBuilder[] spannableStringBuilderArr = a;
        if (spannableStringBuilderArr[i] == null) {
            spannableStringBuilderArr[i] = new SpannableStringBuilder(Separators.GREATER_THAN);
            if (i == 0) {
                i2 = AbstractC23598xB5.attach_arrow_right;
            } else if (i == 1) {
                i2 = AbstractC23598xB5.msg_mini_arrow_mediathin;
            } else {
                if (i != 2) {
                    return "";
                }
                i2 = AbstractC23598xB5.msg_mini_arrow_mediabold;
            }
            SY0 sy0 = new SY0(AbstractC4043Dl1.f(AbstractC14047hG.a, i2).mutate(), i == 0 ? 2 : 1);
            if (i == 1 || i == 2) {
                sy0.a(0.85f);
            }
            SpannableStringBuilder spannableStringBuilder = a[i];
            spannableStringBuilder.setSpan(sy0, 0, spannableStringBuilder.length(), 0);
        }
        CharSequence charSequenceV = null;
        AbstractC19652qi7 abstractC19652qi7S = c10743c74.e.c.b != 0 ? ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).s(Long.valueOf(c10743c74.e.c.b)) : null;
        AbstractC15742k57 abstractC15742k57I = c10743c74.e.c.c != 0 ? ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).i(Long.valueOf(c10743c74.e.d.c)) : null;
        if (abstractC15742k57I == null) {
            abstractC15742k57I = c10743c74.e.c.d != 0 ? ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).i(Long.valueOf(c10743c74.e.d.d)) : null;
        }
        AbstractC15742k57 abstractC15742k57I2 = c10743c74.e.d.d != 0 ? ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).i(Long.valueOf(c10743c74.e.d.d)) : null;
        if (abstractC15742k57I2 == null) {
            abstractC15742k57I2 = c10743c74.e.d.c != 0 ? ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).i(Long.valueOf(c10743c74.e.d.c)) : null;
        }
        if (!AbstractC13547gQ0.g(abstractC15742k57I2) && !z) {
            abstractC15742k57I2 = null;
        }
        if (abstractC19652qi7S != null && abstractC15742k57I2 != null) {
            CharSequence charSequenceV2 = R62.V(abstractC15742k57I2.c, textPaint == null ? null : textPaint.getFontMetricsInt(), false);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(R62.V(LI7.a(abstractC19652qi7S), textPaint != null ? textPaint.getFontMetricsInt() : null, false)).append((char) 8202).append((CharSequence) a[i]).append((char) 8202).append(charSequenceV2);
            charSequenceV = spannableStringBuilder2;
        } else if (abstractC19652qi7S != null) {
            charSequenceV = R62.V(LI7.e(abstractC19652qi7S), textPaint != null ? textPaint.getFontMetricsInt() : null, false);
        } else if (abstractC15742k57I != null) {
            charSequenceV = R62.V(abstractC15742k57I.c, textPaint != null ? textPaint.getFontMetricsInt() : null, false);
        }
        return charSequenceV == null ? "" : charSequenceV;
    }
}
