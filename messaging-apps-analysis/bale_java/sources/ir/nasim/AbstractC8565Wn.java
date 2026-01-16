package ir.nasim;

import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import ir.nasim.C13245fu;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Wn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8565Wn {
    /* JADX WARN: Multi-variable type inference failed */
    public static final C13245fu a(CharSequence charSequence) {
        List list = null;
        Object[] objArr = 0;
        if (charSequence == null) {
            return null;
        }
        if (!(charSequence instanceof Spanned)) {
            return new C13245fu(charSequence.toString(), list, 2, objArr == true ? 1 : 0);
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
                    arrayList.add(new C13245fu.d(new C18750pB1(annotation.getValue()).k(), spanned.getSpanStart(annotation), spanned.getSpanEnd(annotation)));
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
        Q72 q72 = new Q72();
        List listG = c13245fu.g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) listG.get(i);
            C12863fI6 c12863fI6 = (C12863fI6) dVar.a();
            int iB = dVar.b();
            int iC = dVar.c();
            q72.q();
            q72.f(c12863fI6);
            spannableString.setSpan(new Annotation("androidx.compose.text.SpanStyle", q72.p()), iB, iC, 33);
        }
        return spannableString;
    }
}
