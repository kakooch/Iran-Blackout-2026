package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import ir.nasim.Kq8;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class zzaw extends Kq8 {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("name", this.zza);
        map.put("source", this.zzb);
        map.put("medium", this.zzc);
        map.put("keyword", this.zzd);
        map.put("content", this.zze);
        map.put("id", this.zzf);
        map.put("adNetworkId", this.zzg);
        map.put("gclid", this.zzh);
        map.put("dclid", this.zzi);
        map.put("aclid", this.zzj);
        return Kq8.zza(map);
    }

    @Override // ir.nasim.Kq8
    public final /* bridge */ /* synthetic */ void zzc(Kq8 kq8) {
        zzaw zzawVar = (zzaw) kq8;
        if (!TextUtils.isEmpty(this.zza)) {
            zzawVar.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzawVar.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzawVar.zzc = this.zzc;
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            zzawVar.zzd = this.zzd;
        }
        if (!TextUtils.isEmpty(this.zze)) {
            zzawVar.zze = this.zze;
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            zzawVar.zzf = this.zzf;
        }
        if (!TextUtils.isEmpty(this.zzg)) {
            zzawVar.zzg = this.zzg;
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            zzawVar.zzh = this.zzh;
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            zzawVar.zzi = this.zzi;
        }
        if (TextUtils.isEmpty(this.zzj)) {
            return;
        }
        zzawVar.zzj = this.zzj;
    }

    public final void zzn(String str) {
        this.zzj = str;
    }

    public final void zzo(String str) {
        this.zzg = str;
    }

    public final void zzp(String str) {
        this.zze = str;
    }

    public final void zzq(String str) {
        this.zzi = str;
    }

    public final void zzr(String str) {
        this.zzh = str;
    }

    public final void zzs(String str) {
        this.zzf = str;
    }

    public final void zzt(String str) {
        this.zzd = str;
    }

    public final void zzu(String str) {
        this.zzc = str;
    }

    public final void zzv(String str) {
        this.zza = str;
    }

    public final void zzw(String str) {
        this.zzb = str;
    }
}
