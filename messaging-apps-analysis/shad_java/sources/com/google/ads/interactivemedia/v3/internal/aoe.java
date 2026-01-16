package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aoe {
    private final aod a;
    private final Handler b = new Handler();
    private boolean c = false;

    aoe(aod aodVar) {
        this.a = aodVar;
    }

    static final /* synthetic */ void c(aod aodVar, Handler handler) {
        aodVar.a();
        d(aodVar, handler);
    }

    private static void d(final aod aodVar, final Handler handler) {
        handler.postDelayed(new Runnable(aodVar, handler) { // from class: com.google.ads.interactivemedia.v3.internal.aoc
            private final aod a;
            private final Handler b;

            {
                this.a = aodVar;
                this.b = handler;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aoe.c(this.a, this.b);
            }
        }, 200L);
    }

    final void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.a();
        d(this.a, this.b);
    }

    final void b() {
        if (this.c) {
            this.c = false;
            this.b.removeCallbacksAndMessages(null);
        }
    }
}
