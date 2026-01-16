package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzew {
    final /* synthetic */ zzex zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzew(zzex zzexVar, String str, String str2) {
        this.zza = zzexVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zza.zzd().getString(this.zzb, null);
        }
        return this.zzd;
    }

    public final void zzb(String str) {
        SharedPreferences.Editor editorEdit = this.zza.zzd().edit();
        editorEdit.putString(this.zzb, str);
        editorEdit.apply();
        this.zzd = str;
    }
}
