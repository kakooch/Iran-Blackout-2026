package ir.nasim;

import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public abstract class RJ {
    public static final void a(PJ pj, int i) {
        AbstractC13042fc3.i(pj, "<this>");
        pj.x(new int[i]);
        pj.v(new Object[i]);
    }

    public static final int b(PJ pj, int i) {
        AbstractC13042fc3.i(pj, "<this>");
        try {
            return AbstractC13738gk1.a(pj.i(), pj.o(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(PJ pj, Object obj, int i) {
        AbstractC13042fc3.i(pj, "<this>");
        int iO = pj.o();
        if (iO == 0) {
            return -1;
        }
        int iB = b(pj, i);
        if (iB < 0 || AbstractC13042fc3.d(obj, pj.h()[iB])) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < iO && pj.i()[i2] == i) {
            if (AbstractC13042fc3.d(obj, pj.h()[i2])) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && pj.i()[i3] == i; i3--) {
            if (AbstractC13042fc3.d(obj, pj.h()[i3])) {
                return i3;
            }
        }
        return ~i2;
    }

    public static final int d(PJ pj) {
        AbstractC13042fc3.i(pj, "<this>");
        return c(pj, null, 0);
    }
}
