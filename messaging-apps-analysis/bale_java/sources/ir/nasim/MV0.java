package ir.nasim;

import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import ir.nasim.C13245fu;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MV0 {
    public static final C13245fu a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (!(charSequence instanceof Spanned)) {
            return new C13245fu(charSequence.toString(), null, 2, null);
        }
        Spanned spanned = (Spanned) charSequence;
        int i = 0;
        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(0, charSequence.length(), Annotation.class);
        ArrayList arrayList = new ArrayList();
        int iL0 = AbstractC10242bK.l0(annotationArr);
        if (iL0 >= 0) {
            while (true) {
                Annotation annotation = annotationArr[i];
                if (AbstractC13042fc3.d(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                    arrayList.add(new C13245fu.d(new C19341qB1(annotation.getValue()).k(), spanned.getSpanStart(annotation), spanned.getSpanEnd(annotation)));
                }
                if (i == iL0) {
                    break;
                }
                i++;
            }
        }
        return new C13245fu(charSequence.toString(), arrayList, null, 4, null);
    }

    public static final CharSequence b(C13245fu c13245fu) {
        if (c13245fu.g().isEmpty()) {
            return c13245fu.k();
        }
        SpannableString spannableString = new SpannableString(c13245fu.k());
        R72 r72 = new R72();
        List listG = c13245fu.g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) listG.get(i);
            C12863fI6 c12863fI6 = (C12863fI6) dVar.a();
            int iB = dVar.b();
            int iC = dVar.c();
            r72.q();
            r72.f(c12863fI6);
            spannableString.setSpan(new Annotation("androidx.compose.text.SpanStyle", r72.p()), iB, iC, 33);
        }
        return spannableString;
    }

    public static final boolean c(EV0 ev0) {
        return LV0.a(ev0);
    }

    public static final C13245fu d(EV0 ev0) {
        return LV0.b(ev0);
    }

    public static final EV0 e(C13245fu c13245fu) {
        return LV0.c(c13245fu);
    }
}
