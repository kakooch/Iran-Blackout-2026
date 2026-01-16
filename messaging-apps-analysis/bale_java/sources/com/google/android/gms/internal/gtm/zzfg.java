package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.AbstractC3795Cj5;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class zzfg {
    final /* synthetic */ zzfh zza;
    private final String zzb;
    private final long zzc;

    /* synthetic */ zzfg(zzfh zzfhVar, String str, long j, zzff zzffVar) {
        this.zza = zzfhVar;
        AbstractC3795Cj5.f("monitoring");
        AbstractC3795Cj5.a(j > 0);
        this.zzb = "monitoring";
        this.zzc = j;
    }

    private final long zzd() {
        return this.zza.zza.getLong(zzf(), 0L);
    }

    private final String zze() {
        return this.zzb.concat(":count");
    }

    private final String zzf() {
        return this.zzb.concat(":start");
    }

    private final void zzg() {
        long jCurrentTimeMillis = this.zza.zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.zza.edit();
        editorEdit.remove(zze());
        editorEdit.remove(zzb());
        editorEdit.putLong(zzf(), jCurrentTimeMillis);
        editorEdit.commit();
    }

    @VisibleForTesting
    protected final String zzb() {
        return this.zzb.concat(":value");
    }

    public final void zzc(String str) {
        if (zzd() == 0) {
            zzg();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            try {
                long j = this.zza.zza.getLong(zze(), 0L);
                if (j <= 0) {
                    SharedPreferences.Editor editorEdit = this.zza.zza.edit();
                    editorEdit.putString(zzb(), str);
                    editorEdit.putLong(zze(), 1L);
                    editorEdit.apply();
                    return;
                }
                long leastSignificantBits = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
                long j2 = j + 1;
                long j3 = Long.MAX_VALUE / j2;
                SharedPreferences.Editor editorEdit2 = this.zza.zza.edit();
                if (leastSignificantBits < j3) {
                    editorEdit2.putString(zzb(), str);
                }
                editorEdit2.putLong(zze(), j2);
                editorEdit2.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
