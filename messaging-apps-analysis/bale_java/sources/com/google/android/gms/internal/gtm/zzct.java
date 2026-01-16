package com.google.android.gms.internal.gtm;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC7666Sr5;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzct {
    private final zzbv zza;
    private volatile Boolean zzb;
    private String zzc;
    private Set<Integer> zzd;

    protected zzct(zzbv zzbvVar) {
        AbstractC3795Cj5.j(zzbvVar);
        this.zza = zzbvVar;
    }

    public static final long zzc() {
        return zzeu.zzG.zzb().longValue();
    }

    public static final long zzd() {
        return zzeu.zzm.zzb().longValue();
    }

    public static final long zze() {
        return zzeu.zzj.zzb().longValue();
    }

    public static final int zzf() {
        return zzeu.zzy.zzb().intValue();
    }

    public static final int zzg() {
        return zzeu.zzp.zzb().intValue();
    }

    public static final int zzh() {
        return zzeu.zzo.zzb().intValue();
    }

    @VisibleForTesting
    public static final String zzi() {
        return zzeu.zzr.zzb();
    }

    public static final String zzj() {
        return zzeu.zzs.zzb();
    }

    @VisibleForTesting
    public static final String zzk() {
        return zzeu.zzq.zzb();
    }

    public static final boolean zzl() {
        return zzeu.zzb.zzb().booleanValue();
    }

    public final Set<Integer> zza() {
        String str;
        String strZzb = zzeu.zzB.zzb();
        if (this.zzd == null || (str = this.zzc) == null || !str.equals(strZzb)) {
            String[] strArrSplit = TextUtils.split(strZzb, ",");
            HashSet hashSet = new HashSet();
            for (String str2 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzc = strZzb;
            this.zzd = hashSet;
        }
        return this.zzd;
    }

    public final boolean zzb() {
        if (this.zzb == null) {
            synchronized (this) {
                try {
                    if (this.zzb == null) {
                        ApplicationInfo applicationInfo = this.zza.zza().getApplicationInfo();
                        String strA = AbstractC7666Sr5.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(strA)) {
                                z = true;
                            }
                            this.zzb = Boolean.valueOf(z);
                        }
                        if ((this.zzb == null || !this.zzb.booleanValue()) && "com.google.android.gms.analytics".equals(strA)) {
                            this.zzb = Boolean.TRUE;
                        }
                        if (this.zzb == null) {
                            this.zzb = Boolean.TRUE;
                            this.zza.zzm().zzJ("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.zzb.booleanValue();
    }
}
