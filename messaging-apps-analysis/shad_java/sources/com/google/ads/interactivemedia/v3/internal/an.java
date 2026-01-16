package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class an implements Runnable {
    an() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (aq.c != null) {
            aq.c.post(aq.j);
            aq.c.postDelayed(aq.k, 200L);
        }
    }
}
