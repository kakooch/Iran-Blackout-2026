package androidx.lifecycle;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15087iz3;
import ir.nasim.AbstractC16775lq5;
import ir.nasim.C12366eV1;
import ir.nasim.P17;

/* loaded from: classes2.dex */
public abstract class o {
    public static final AbstractC15087iz3 a(j jVar) {
        l lVar;
        AbstractC13042fc3.i(jVar, "<this>");
        do {
            l lVar2 = (l) jVar.c().get();
            if (lVar2 != null) {
                return lVar2;
            }
            lVar = new l(jVar, P17.b(null, 1, null).X(C12366eV1.c().F0()));
        } while (!AbstractC16775lq5.a(jVar.c(), null, lVar));
        lVar.f();
        return lVar;
    }
}
