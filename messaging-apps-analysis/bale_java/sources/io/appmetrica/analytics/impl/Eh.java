package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Eh {
    public final HashMap a = new HashMap();
    public final C2743o0 b;

    public Eh(C2743o0 c2743o0) {
        this.b = c2743o0;
    }

    public static Eh a() {
        return Dh.a;
    }

    public final C2951wh a(Context context, String str) {
        C2951wh c2951wh = (C2951wh) this.a.get(str);
        if (c2951wh == null) {
            synchronized (this.a) {
                try {
                    c2951wh = (C2951wh) this.a.get(str);
                    if (c2951wh == null) {
                        IHandlerExecutor iHandlerExecutorA = C2747o4.g().c.a();
                        this.b.getClass();
                        if (C2719n0.e == null) {
                            ((C2871t9) iHandlerExecutorA).b.post(new Ch(this, context));
                        }
                        c2951wh = new C2951wh(context.getApplicationContext(), str, new C2743o0());
                        this.a.put(str, c2951wh);
                        c2951wh.c(str);
                    }
                } finally {
                }
            }
        }
        return c2951wh;
    }
}
