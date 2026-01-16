package ir.nasim;

import android.text.Spannable;
import ir.nasim.AbstractC4701Ge5;
import ir.nasim.C13245fu;
import ir.nasim.C14377ho7;
import java.util.List;

/* renamed from: ir.nasim.ze5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25047ze5 {
    private static final int a(long j) {
        long jG = C13193fo7.g(j);
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.b())) {
            return 0;
        }
        return C14377ho7.g(jG, aVar.a()) ? 1 : 2;
    }

    private static final int b(int i) {
        AbstractC4701Ge5.a aVar = AbstractC4701Ge5.a;
        if (AbstractC4701Ge5.i(i, aVar.a())) {
            return 0;
        }
        if (AbstractC4701Ge5.i(i, aVar.g())) {
            return 1;
        }
        if (AbstractC4701Ge5.i(i, aVar.b())) {
            return 2;
        }
        if (AbstractC4701Ge5.i(i, aVar.c())) {
            return 3;
        }
        if (AbstractC4701Ge5.i(i, aVar.f())) {
            return 4;
        }
        if (AbstractC4701Ge5.i(i, aVar.d())) {
            return 5;
        }
        if (AbstractC4701Ge5.i(i, aVar.e())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    private static final void c(Spannable spannable, C23863xe5 c23863xe5, int i, int i2, WH1 wh1) {
        for (Object obj : spannable.getSpans(i, i2, AbstractC22956w62.class)) {
            spannable.removeSpan((AbstractC22956w62) obj);
        }
        AbstractC15863kI6.v(spannable, new C3984De5(C13193fo7.h(c23863xe5.c()), a(c23863xe5.c()), C13193fo7.h(c23863xe5.a()), a(c23863xe5.a()), wh1.t1() * wh1.getDensity(), b(c23863xe5.b())), i, i2);
    }

    public static final void d(Spannable spannable, List list, WH1 wh1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i);
            c(spannable, (C23863xe5) dVar.a(), dVar.b(), dVar.c(), wh1);
        }
    }
}
