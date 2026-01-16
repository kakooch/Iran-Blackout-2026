package ir.nasim;

import ir.nasim.AbstractC20693sS0;
import java.util.List;

/* renamed from: ir.nasim.o1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18058o1 {
    public final AbstractC20693sS0 a(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        for (AS0 as0 : b()) {
            if (as0.b(ab2)) {
                return as0.a(ab2);
            }
        }
        return AbstractC20693sS0.a.b;
    }

    public abstract List b();
}
