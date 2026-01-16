package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.nH7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17628nH7 {
    private final List a = new ArrayList();

    public final C17037mH7 a(long j) {
        Object next;
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C17037mH7) next).a() == j) {
                break;
            }
        }
        return (C17037mH7) next;
    }

    public final C17037mH7 b(long j, C17037mH7 c17037mH7) {
        AbstractC13042fc3.i(c17037mH7, "newData");
        C17037mH7 c17037mH7A = a(j);
        if (c17037mH7A != null) {
            return c17037mH7A;
        }
        this.a.add(c17037mH7);
        return c17037mH7;
    }

    public final boolean c(long j) {
        Iterator it = this.a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((C17037mH7) it.next()).a() == j) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.a.remove(i);
        return true;
    }
}
