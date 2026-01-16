package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Gk {
    public final C2633ja a = new C2633ja();
    public final HashMap b = new HashMap();
    public C2549fl c = null;
    public final Ek d = new Ek(this);

    public static final Gk a() {
        return Fk.a;
    }

    public final Bl a(Context context, W4 w4, Yk yk) {
        Bl bl = (Bl) this.b.get(w4.a);
        boolean z = true;
        if (bl == null) {
            synchronized (this.b) {
                try {
                    bl = (Bl) this.b.get(w4.a);
                    if (bl == null) {
                        bl = new Bl(new Cl(context, w4.a, yk, this.d));
                        bl.f();
                        this.b.put(w4.a, bl);
                        z = false;
                    }
                } finally {
                }
            }
        }
        if (z) {
            bl.a(yk);
        }
        return bl;
    }

    public final void a(W4 w4, Pk pk) {
        synchronized (this.b) {
            try {
                this.a.a(w4.a, pk);
                C2549fl c2549fl = this.c;
                if (c2549fl != null) {
                    pk.a(c2549fl);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
