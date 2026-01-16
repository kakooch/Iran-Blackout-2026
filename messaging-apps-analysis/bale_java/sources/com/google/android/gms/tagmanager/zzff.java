package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzff extends zzey {
    private static final Object zza = new Object();
    private static zzff zzb;
    private boolean zze = true;
    private boolean zzf = false;
    private boolean zzg = true;
    private final zzez zzl = new zzez(this);
    private boolean zzj = false;

    private zzff() {
    }

    static /* bridge */ /* synthetic */ zzcd zze(zzff zzffVar) {
        zzffVar.getClass();
        return null;
    }

    public static zzff zzg() {
        if (zzb == null) {
            zzb = new zzff();
        }
        return zzb;
    }

    @Override // com.google.android.gms.tagmanager.zzey
    public final synchronized void zza() {
        if (this.zzf) {
            new zzfa(this);
            throw null;
        }
        zzdh.zzb.zzd("Dispatch call queued. Dispatch will run once initialization is complete.");
        this.zze = true;
    }
}
