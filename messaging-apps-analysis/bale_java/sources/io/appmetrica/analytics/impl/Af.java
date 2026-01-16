package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Af {
    public final HashSet a = new HashSet();
    public Cf b;
    public boolean c;
    public final sn d;
    public final Context e;

    public Af(Context context, sn snVar) {
        this.e = context;
        this.d = snVar;
        this.b = snVar.b();
        this.c = snVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        Ia iaA = Kf.a(context, C2586ha.C.d.a());
        Hf hf = (Hf) new C2829rf(this, new Kf(iaA), new C2872ta(context), new Lf(context)).f.getValue();
        try {
            iaA.a(hf);
        } catch (Throwable th) {
            hf.a(th);
        }
    }

    public final synchronized void a(Ef ef) {
        this.a.add(ef);
        if (this.c) {
            ef.a(this.b);
        }
    }

    public final synchronized void a(Cf cf) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Ef) it.next()).a(cf);
        }
    }
}
