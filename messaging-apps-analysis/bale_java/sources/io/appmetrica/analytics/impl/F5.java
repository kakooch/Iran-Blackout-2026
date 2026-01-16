package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.impl.EnumC2694m;

/* loaded from: classes3.dex */
public final class F5 {
    public final C2766p a;
    public final IReporter b;
    public Context c;
    public final InterfaceC2718n d;

    public F5(C2766p c2766p) {
        this(c2766p, 0);
    }

    public static final void a(F5 f5, Activity activity, EnumC2694m enumC2694m) {
        int iOrdinal = enumC2694m.ordinal();
        if (iOrdinal == 1) {
            f5.b.resumeSession();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            f5.b.pauseSession();
        }
    }

    public F5(C2766p c2766p, IReporter iReporter) {
        this.a = c2766p;
        this.b = iReporter;
        this.d = new InterfaceC2718n() { // from class: ir.nasim.ff2
            @Override // io.appmetrica.analytics.impl.InterfaceC2718n
            public final void a(Activity activity, EnumC2694m enumC2694m) {
                io.appmetrica.analytics.impl.F5.a(this.a, activity, enumC2694m);
            }
        };
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.a.a(applicationContext);
            this.a.a(this.d, EnumC2694m.RESUMED, EnumC2694m.PAUSED);
            this.c = applicationContext;
        }
    }

    public /* synthetic */ F5(C2766p c2766p, int i) {
        this(c2766p, AbstractC2648k1.a());
    }
}
