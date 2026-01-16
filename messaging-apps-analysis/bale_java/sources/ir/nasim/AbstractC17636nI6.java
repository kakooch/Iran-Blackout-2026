package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import ir.nasim.C9475a16;
import java.util.ArrayList;

/* renamed from: ir.nasim.nI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17636nI6 {
    public static final String a(Spannable spannable) {
        Object objB;
        AbstractC13042fc3.i(spannable, "spannable");
        try {
            C9475a16.a aVar = C9475a16.b;
            L46[] l46Arr = (L46[]) spannable.getSpans(0, spannable.length(), L46.class);
            AbstractC13042fc3.f(l46Arr);
            ArrayList arrayList = new ArrayList(l46Arr.length);
            for (L46 l46 : l46Arr) {
                arrayList.add(spannable.subSequence(spannable.getSpanStart(l46), spannable.getSpanEnd(l46)).toString());
            }
            objB = C9475a16.b((String) AbstractC15401jX0.s0(arrayList));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }

    public static final Spannable b(int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Separators.SP);
        spannableStringBuilder.setSpan(new YH6(AbstractC8943Xx1.c(i)), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final Spannable c(Spannable spannable, int i, boolean z, int i2, int i3) {
        AbstractC13042fc3.i(spannable, "<this>");
        spannable.setSpan(new AbsoluteSizeSpan(i, z), i2, i3, 17);
        return spannable;
    }

    public static /* synthetic */ Spannable d(Spannable spannable, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = spannable.length();
        }
        return c(spannable, i, z, i2, i3);
    }

    public static final Spannable e(Spannable spannable, int i, int i2, int i3) {
        AbstractC13042fc3.i(spannable, "<this>");
        spannable.setSpan(new ForegroundColorSpan(i), i2, i3, 17);
        return spannable;
    }

    public static /* synthetic */ Spannable f(Spannable spannable, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = spannable.length();
        }
        return e(spannable, i, i2, i3);
    }

    public static final Spannable g(Spannable spannable, int i, int i2, int i3, int i4) {
        AbstractC13042fc3.i(spannable, "<this>");
        spannable.setSpan(new K46(i, i2), i3, i4, 17);
        return spannable;
    }

    public static /* synthetic */ Spannable h(Spannable spannable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 20;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = spannable.length();
        }
        return g(spannable, i, i2, i3, i4);
    }

    public static final SpannableString i(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return new SpannableString(str);
    }
}
