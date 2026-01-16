package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
abstract class zzjv extends zzju {
    private boolean zzb;

    zzjv(zzkd zzkdVar) {
        super(zzkdVar);
        this.zza.zzP();
    }

    final boolean zzW() {
        return this.zzb;
    }

    protected final void zzX() {
        if (!zzW()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean zzaz();

    public final void zzY() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaz();
        this.zza.zzQ();
        this.zzb = true;
    }
}
