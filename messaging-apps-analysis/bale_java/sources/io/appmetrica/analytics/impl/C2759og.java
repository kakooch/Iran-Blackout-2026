package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.og, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2759og extends AbstractC2568gg {
    public final tn b;

    public C2759og(C2484d5 c2484d5) {
        this(c2484d5, c2484d5.u());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        C2484d5 c2484d5 = this.a;
        if (this.b.c()) {
            return false;
        }
        if (!this.b.d()) {
            C2537f9 c2537f9 = c2484d5.o;
            c2537f9.c.b(Q5.a(q5, Ta.EVENT_TYPE_FIRST_ACTIVATION));
        }
        tn tnVar = this.b;
        synchronized (tnVar) {
            un unVar = tnVar.a;
            unVar.a(unVar.a().put("first_event_done", true));
        }
        return false;
    }

    public C2759og(C2484d5 c2484d5, tn tnVar) {
        super(c2484d5);
        this.b = tnVar;
    }
}
