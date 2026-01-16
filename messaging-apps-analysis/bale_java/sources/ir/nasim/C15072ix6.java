package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.ix6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15072ix6 implements BQ7 {
    public static final C15072ix6 a = new C15072ix6();
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("c", "v", "i", "o");

    private C15072ix6() {
    }

    @Override // ir.nasim.BQ7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14465hx6 a(AbstractC11911dl3 abstractC11911dl3, float f) {
        if (abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY) {
            abstractC11911dl3.b();
        }
        abstractC11911dl3.B();
        List listF = null;
        List listF2 = null;
        List listF3 = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(b);
            if (iL == 0) {
                zE = abstractC11911dl3.e();
            } else if (iL == 1) {
                listF = AbstractC20878sl3.f(abstractC11911dl3, f);
            } else if (iL == 2) {
                listF2 = AbstractC20878sl3.f(abstractC11911dl3, f);
            } else if (iL != 3) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                listF3 = AbstractC20878sl3.f(abstractC11911dl3, f);
            }
        }
        abstractC11911dl3.F();
        if (abstractC11911dl3.j() == AbstractC11911dl3.b.END_ARRAY) {
            abstractC11911dl3.c();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new C14465hx6(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = (PointF) listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = (PointF) listF.get(i);
            int i2 = i - 1;
            arrayList.add(new C13267fw1(AbstractC7323Rf4.a((PointF) listF.get(i2), (PointF) listF3.get(i2)), AbstractC7323Rf4.a(pointF2, (PointF) listF2.get(i)), pointF2));
        }
        if (zE) {
            PointF pointF3 = (PointF) listF.get(0);
            int i3 = size - 1;
            arrayList.add(new C13267fw1(AbstractC7323Rf4.a((PointF) listF.get(i3), (PointF) listF3.get(i3)), AbstractC7323Rf4.a(pointF3, (PointF) listF2.get(0)), pointF3));
        }
        return new C14465hx6(pointF, zE, arrayList);
    }
}
