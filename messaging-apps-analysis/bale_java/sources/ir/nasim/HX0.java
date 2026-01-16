package ir.nasim;

import android.graphics.Color;
import ir.nasim.AbstractC11911dl3;

/* loaded from: classes2.dex */
public class HX0 implements BQ7 {
    public static final HX0 a = new HX0();

    private HX0() {
    }

    @Override // ir.nasim.BQ7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(AbstractC11911dl3 abstractC11911dl3, float f) {
        boolean z = abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY;
        if (z) {
            abstractC11911dl3.b();
        }
        double dF1 = abstractC11911dl3.f1();
        double dF12 = abstractC11911dl3.f1();
        double dF13 = abstractC11911dl3.f1();
        double dF14 = abstractC11911dl3.j() == AbstractC11911dl3.b.NUMBER ? abstractC11911dl3.f1() : 1.0d;
        if (z) {
            abstractC11911dl3.c();
        }
        if (dF1 <= 1.0d && dF12 <= 1.0d && dF13 <= 1.0d) {
            dF1 *= 255.0d;
            dF12 *= 255.0d;
            dF13 *= 255.0d;
            if (dF14 <= 1.0d) {
                dF14 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dF14, (int) dF1, (int) dF12, (int) dF13));
    }
}
