package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ir.nasim.C13245fu;
import ir.nasim.core.markdown.code.ViewSourceCodeSpan;
import okio.Utf8;

/* loaded from: classes4.dex */
public abstract class LO3 {
    public static final C13245fu a(AbstractC17150mU3 abstractC17150mU3, CharSequence charSequence) {
        AbstractC13042fc3.i(abstractC17150mU3, "<this>");
        AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
        return b(new SpannableStringBuilder(abstractC17150mU3.b(charSequence.toString())));
    }

    private static final C13245fu b(Spannable spannable) {
        C13245fu.b bVar = new C13245fu.b(0, 1, null);
        int length = spannable.length();
        int i = 0;
        while (i < length) {
            int iNextSpanTransition = spannable.nextSpanTransition(i, length, Object.class);
            bVar.h(spannable.subSequence(i, iNextSpanTransition).toString());
            Object[] spans = spannable.getSpans(i, iNextSpanTransition, Object.class);
            AbstractC13042fc3.f(spans);
            for (Object obj : spans) {
                if (obj instanceof DZ6) {
                    bVar.b(new C12863fI6(0L, 0L, C4593Fu2.b.a(), (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65531, (ED1) null), i, iNextSpanTransition);
                } else if (obj instanceof StyleSpan) {
                    int style = ((StyleSpan) obj).getStyle();
                    if (style == 1) {
                        bVar.b(new C12863fI6(0L, 0L, C4593Fu2.b.a(), (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65531, (ED1) null), i, iNextSpanTransition);
                    } else if (style == 2) {
                        bVar.b(new C12863fI6(0L, 0L, (C4593Fu2) null, C3418Au2.c(C3418Au2.b.a()), (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65527, (ED1) null), i, iNextSpanTransition);
                    }
                } else if (obj instanceof UnderlineSpan) {
                    bVar.b(new C12863fI6(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61439, (ED1) null), i, iNextSpanTransition);
                } else if (obj instanceof ForegroundColorSpan) {
                    bVar.b(new C12863fI6(DX0.b(((ForegroundColorSpan) obj).getForegroundColor()), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null), i, iNextSpanTransition);
                } else if (obj instanceof AbsoluteSizeSpan) {
                    bVar.b(new C12863fI6(0L, AbstractC13784go7.g(((AbsoluteSizeSpan) obj).getSize()), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, Utf8.REPLACEMENT_CODE_POINT, (ED1) null), i, iNextSpanTransition);
                } else if (obj instanceof RelativeSizeSpan) {
                    bVar.b(new C12863fI6(0L, AbstractC13784go7.d(((RelativeSizeSpan) obj).getSizeChange()), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, Utf8.REPLACEMENT_CODE_POINT, (ED1) null), i, iNextSpanTransition);
                } else if (obj instanceof ViewSourceCodeSpan) {
                    bVar.b(new C12863fI6(C24381yX0.b.b(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61438, (ED1) null), i, iNextSpanTransition);
                }
            }
            i = iNextSpanTransition;
        }
        return bVar.o();
    }
}
