package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzr {
    private final zzfl zza;

    public zzr(zzfl zzflVar) {
        this.zza = zzflVar;
    }

    final void zza() {
        this.zza.zzau().zzg();
        if (zze()) {
            if (zzd()) {
                this.zza.zzd().zzu.zzb(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.zza.zzk().zzs("auto", "_cmpx", bundle);
            } else {
                String strZza = this.zza.zzd().zzu.zza();
                if (TextUtils.isEmpty(strZza)) {
                    this.zza.zzat().zzc().zza("Cache still valid but referrer not found");
                } else {
                    long jZza = ((this.zza.zzd().zzv.zza() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strZza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jZza);
                    this.zza.zzk().zzs((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.zza.zzd().zzu.zzb(null);
            }
            this.zza.zzd().zzv.zzb(0L);
        }
    }

    final void zzb(String str, Bundle bundle) {
        String string;
        this.zza.zzau().zzg();
        if (this.zza.zzF()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.zza.zzd().zzu.zzb(string);
        this.zza.zzd().zzv.zzb(this.zza.zzax().currentTimeMillis());
    }

    final void zzc() {
        if (zze() && zzd()) {
            this.zza.zzd().zzu.zzb(null);
        }
    }

    final boolean zzd() {
        return zze() && this.zza.zzax().currentTimeMillis() - this.zza.zzd().zzv.zza() > this.zza.zzc().zzj(null, zzdw.zzQ);
    }

    final boolean zze() {
        return this.zza.zzd().zzv.zza() > 0;
    }
}
