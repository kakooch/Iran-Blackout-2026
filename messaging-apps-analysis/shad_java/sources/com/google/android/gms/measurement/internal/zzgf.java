package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
abstract class zzgf extends zzge {
    private boolean zza;

    zzgf(zzfl zzflVar) {
        super(zzflVar);
        this.zzx.zzJ();
    }

    protected abstract boolean zza();

    protected void zzay() {
    }

    final boolean zzu() {
        return this.zza;
    }

    protected final void zzv() {
        if (!zzu()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zza()) {
            return;
        }
        this.zzx.zzK();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzay();
        this.zzx.zzK();
        this.zza = true;
    }
}
