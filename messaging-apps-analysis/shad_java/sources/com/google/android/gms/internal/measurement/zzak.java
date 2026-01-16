package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzak extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzbr zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzak(zzbr zzbrVar, String str, String str2, Context context, Bundle bundle) {
        super(zzbrVar, true);
        this.zze = zzbrVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    public final void zza() {
        String str;
        String str2;
        String str3;
        int iMax;
        boolean z;
        try {
            zzbr zzbrVar = this.zze;
            if (zzbr.zzX(this.zza, this.zzb)) {
                String str4 = this.zzb;
                str2 = this.zza;
                str3 = str4;
                str = this.zze.zzd;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            zzbr.zzO(this.zzc);
            boolean z2 = zzbr.zzh.booleanValue() || str2 != null;
            zzbr zzbrVar2 = this.zze;
            zzbrVar2.zzk = zzbrVar2.zzc(this.zzc, z2);
            if (this.zze.zzk == null) {
                Log.w(this.zze.zzd, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            if (z2) {
                iMax = Math.max(localVersion, remoteVersion);
                z = remoteVersion < localVersion;
            } else {
                if (localVersion > 0) {
                    remoteVersion = localVersion;
                }
                iMax = remoteVersion;
                z = localVersion > 0;
            }
            this.zze.zzk.initialize(ObjectWrapper.wrap(this.zzc), new zzy(39000L, iMax, z, str, str2, str3, this.zzd, com.google.android.gms.measurement.internal.zzfd.zza(this.zzc)), this.zzh);
        } catch (Exception e) {
            this.zze.zzV(e, true, false);
        }
    }
}
