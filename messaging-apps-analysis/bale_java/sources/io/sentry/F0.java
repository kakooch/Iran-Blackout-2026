package io.sentry;

/* loaded from: classes3.dex */
final class F0 implements Runnable {
    private final C3155n3 a;

    F0(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.a.getCacheDirPath();
        if (cacheDirPath == null) {
            this.a.getLogger().c(Y2.INFO, "Cache dir is not set, not moving the previous session.", new Object[0]);
            return;
        }
        if (!this.a.isEnableAutoSessionTracking()) {
            this.a.getLogger().c(Y2.DEBUG, "Session tracking is disabled, bailing from previous session mover.", new Object[0]);
            return;
        }
        io.sentry.cache.g envelopeDiskCache = this.a.getEnvelopeDiskCache();
        if (envelopeDiskCache instanceof io.sentry.cache.f) {
            io.sentry.cache.f fVar = (io.sentry.cache.f) envelopeDiskCache;
            fVar.V(io.sentry.cache.f.P(cacheDirPath), io.sentry.cache.f.R(cacheDirPath));
            fVar.O();
        }
    }
}
