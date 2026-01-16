package ir.nasim;

import ir.nasim.AbstractC9998au2;
import java.util.List;

/* renamed from: ir.nasim.Cl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3815Cl7 {
    public static final int a(float f) {
        return Math.round((float) Math.ceil(f));
    }

    public static final C3342Al7 b(C3342Al7 c3342Al7, C13245fu c13245fu, C9348Zn7 c9348Zn7, WH1 wh1, AbstractC9998au2.b bVar, boolean z, int i, int i2, int i3, List list) {
        if (!AbstractC13042fc3.d(c3342Al7.k(), c13245fu) || !AbstractC13042fc3.d(c3342Al7.j(), c9348Zn7) || c3342Al7.i() != z) {
            return new C3342Al7(c13245fu, c9348Zn7, i2, i3, z, i, wh1, bVar, list, null);
        }
        if (!AbstractC23365wn7.g(c3342Al7.g(), i)) {
            return new C3342Al7(c13245fu, c9348Zn7, i2, i3, z, i, wh1, bVar, list, null);
        }
        if (c3342Al7.d() != i2) {
            return new C3342Al7(c13245fu, c9348Zn7, i2, i3, z, i, wh1, bVar, list, null);
        }
        if (c3342Al7.e() == i3 && AbstractC13042fc3.d(c3342Al7.a(), wh1)) {
            if (AbstractC13042fc3.d(c3342Al7.h(), list) && c3342Al7.b() == bVar) {
                return c3342Al7;
            }
            return new C3342Al7(c13245fu, c9348Zn7, i2, i3, z, i, wh1, bVar, list, null);
        }
        return new C3342Al7(c13245fu, c9348Zn7, i2, i3, z, i, wh1, bVar, list, null);
    }
}
