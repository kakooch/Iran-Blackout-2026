package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zabi implements Runnable {
    private final /* synthetic */ zabg zaa;

    zabi(zabg zabgVar) {
        this.zaa = zabgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zaa.zac.disconnect(this.zaa.zaa.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
