package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzho;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzc implements zzho {
    final /* synthetic */ zzbr zza;

    zzc(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final Map<String, Object> zzc(String str, String str2, boolean z) {
        return this.zza.zzB(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final String zzg() {
        return this.zza.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final String zzh() {
        return this.zza.zzA();
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final String zzi() {
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final String zzj() {
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final long zzk() {
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final void zzl(String str) {
        this.zza.zzu(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final void zzm(String str) {
        this.zza.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final void zzn(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final void zzo(String str, String str2, Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final List<Bundle> zzp(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzho
    public final int zzq(String str) {
        return this.zza.zzE(str);
    }
}
