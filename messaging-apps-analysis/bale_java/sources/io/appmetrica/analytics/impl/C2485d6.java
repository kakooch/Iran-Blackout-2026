package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import ir.nasim.C19938rB7;

/* renamed from: io.appmetrica.analytics.impl.d6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2485d6 extends C2520eg {
    public final Context f;
    public final Ng g;
    public final Sb h;
    public final C2701m6 i;

    public C2485d6(Context context, C2552g0 c2552g0, Zj zj, Ng ng) {
        super(c2552g0, zj, ng);
        this.f = context;
        this.g = ng;
        this.h = C2747o4.g().h();
        this.i = new C2701m6(context);
    }

    public final void a(Ng ng) {
        if (ng.a.g != 0) {
            this.i.a(ng);
            return;
        }
        Intent intentA = Aj.a(this.f);
        Q5 q5 = ng.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 5890;
        intentA.putExtras(q5.d(ng.e.c()));
        try {
            this.f.startService(intentA);
        } catch (Throwable unused) {
            this.i.a(ng);
        }
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final boolean c() {
        a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Pg, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return C19938rB7.a;
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final synchronized void a() {
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.h.a("AppMetrica")) {
                this.i.a(this.g);
            } else {
                this.a.c();
                this.c = false;
                super.a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
