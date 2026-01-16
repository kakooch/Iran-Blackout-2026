package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzmo implements zzmn {
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzd;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zzfeVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzfeVar.zzb("measurement.lifecycle.app_backgrounded_engagement", false);
        zzfeVar.zzb("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzfeVar.zzb("measurement.lifecycle.app_in_background_parameter", false);
        zzfeVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final boolean zza() {
        return zzb.zze().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmn
    public final boolean zzb() {
        return zzd.zze().booleanValue();
    }
}
