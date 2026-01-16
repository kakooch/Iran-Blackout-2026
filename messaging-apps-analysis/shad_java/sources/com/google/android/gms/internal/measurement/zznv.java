package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zznv implements zznu {
    public static final zzfg<Boolean> zza;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zzb("measurement.upload.file_lock_state_check", false);
        zzfeVar.zza("measurement.id.upload.file_lock_state_check", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
