package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzgn {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzy zzg;
    boolean zzh;
    final Long zzi;
    String zzj;

    public zzgn(Context context, com.google.android.gms.internal.measurement.zzy zzyVar, Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzyVar != null) {
            this.zzg = zzyVar;
            this.zzb = zzyVar.zzf;
            this.zzc = zzyVar.zze;
            this.zzd = zzyVar.zzd;
            this.zzh = zzyVar.zzc;
            this.zzf = zzyVar.zzb;
            this.zzj = zzyVar.zzh;
            Bundle bundle = zzyVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
