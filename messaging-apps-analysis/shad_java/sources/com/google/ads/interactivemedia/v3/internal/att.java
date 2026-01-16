package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class att extends ate<Void> implements Runnable {
    private final Runnable a;

    public att(Runnable runnable) {
        aqd.j(runnable);
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            o(th);
            aqf.a(th);
            throw new RuntimeException(th);
        }
    }
}
