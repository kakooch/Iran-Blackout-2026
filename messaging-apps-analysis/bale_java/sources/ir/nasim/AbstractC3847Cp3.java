package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Cp3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC3847Cp3 {
    static AbstractC11911dl3.a a = AbstractC11911dl3.a.a("k");

    static List a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, float f, BQ7 bq7, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (abstractC11911dl3.j() == AbstractC11911dl3.b.STRING) {
            c23677xK3.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        abstractC11911dl3.B();
        while (abstractC11911dl3.d()) {
            if (abstractC11911dl3.l(a) != 0) {
                abstractC11911dl3.R();
            } else if (abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY) {
                abstractC11911dl3.b();
                if (abstractC11911dl3.j() == AbstractC11911dl3.b.NUMBER) {
                    arrayList.add(AbstractC3613Bp3.c(abstractC11911dl3, c23677xK3, f, bq7, false, z));
                } else {
                    while (abstractC11911dl3.d()) {
                        arrayList.add(AbstractC3613Bp3.c(abstractC11911dl3, c23677xK3, f, bq7, true, z));
                    }
                }
                abstractC11911dl3.c();
            } else {
                arrayList.add(AbstractC3613Bp3.c(abstractC11911dl3, c23677xK3, f, bq7, false, z));
            }
        }
        abstractC11911dl3.F();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i;
        Object obj;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            C24561yp3 c24561yp3 = (C24561yp3) list.get(i2);
            i2++;
            C24561yp3 c24561yp32 = (C24561yp3) list.get(i2);
            c24561yp3.h = Float.valueOf(c24561yp32.g);
            if (c24561yp3.c == null && (obj = c24561yp32.b) != null) {
                c24561yp3.c = obj;
                if (c24561yp3 instanceof C16291l15) {
                    ((C16291l15) c24561yp3).j();
                }
            }
        }
        C24561yp3 c24561yp33 = (C24561yp3) list.get(i);
        if ((c24561yp33.b == null || c24561yp33.c == null) && list.size() > 1) {
            list.remove(c24561yp33);
        }
    }
}
