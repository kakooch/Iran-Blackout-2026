package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Ef0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC4222Ef0 {
    static C3988Df0 a(List list) {
        int size = list.size() << 1;
        int i = size - 1;
        if (((C16061ke2) list.get(list.size() - 1)).d() == null) {
            i = size - 2;
        }
        C3988Df0 c3988Df0 = new C3988Df0(i * 12);
        int i2 = 0;
        int iB = ((C16061ke2) list.get(0)).d().b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iB) != 0) {
                c3988Df0.s(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            C16061ke2 c16061ke2 = (C16061ke2) list.get(i4);
            int iB2 = c16061ke2.c().b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & iB2) != 0) {
                    c3988Df0.s(i2);
                }
                i2++;
            }
            if (c16061ke2.d() != null) {
                int iB3 = c16061ke2.d().b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & iB3) != 0) {
                        c3988Df0.s(i2);
                    }
                    i2++;
                }
            }
        }
        return c3988Df0;
    }
}
