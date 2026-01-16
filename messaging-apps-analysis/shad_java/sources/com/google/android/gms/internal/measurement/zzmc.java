package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzmc implements zzmb {
    public static final zzfg<Boolean> zzb;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zzfeVar.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzfeVar.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
        zzfeVar.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    public final boolean zza() {
        return zzb.zze().booleanValue();
    }
}
