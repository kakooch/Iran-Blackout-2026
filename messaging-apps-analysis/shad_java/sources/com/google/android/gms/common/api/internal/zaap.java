package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
abstract class zaap implements Runnable {
    private final /* synthetic */ zaaf zaa;

    private zaap(zaaf zaafVar) {
        this.zaa = zaafVar;
    }

    protected abstract void zaa();

    @Override // java.lang.Runnable
    public void run() {
        this.zaa.zab.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            zaa();
        } catch (RuntimeException e) {
            this.zaa.zaa.zaa(e);
        } finally {
            this.zaa.zab.unlock();
        }
    }

    /* synthetic */ zaap(zaaf zaafVar, zaae zaaeVar) {
        this(zaafVar);
    }
}
