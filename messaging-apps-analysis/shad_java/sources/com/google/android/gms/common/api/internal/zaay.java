package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
abstract class zaay {
    private final zaaw zaa;

    protected zaay(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    protected abstract void zaa();

    public final void zaa(zaaz zaazVar) {
        zaazVar.zaf.lock();
        try {
            if (zaazVar.zan != this.zaa) {
                return;
            }
            zaa();
        } finally {
            zaazVar.zaf.unlock();
        }
    }
}
