package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzeg {
    final /* synthetic */ zzei zza;
    private final int zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzeg(zzei zzeiVar, int i, boolean z, boolean z2) {
        this.zza = zzeiVar;
        this.zzb = i;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void zza(String str) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, null, null, null);
    }

    public final void zzb(String str, Object obj) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, obj2, null);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, obj2, obj3);
    }
}
