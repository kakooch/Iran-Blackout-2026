package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdv<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzdt<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze = new Object();
    private volatile V zzg = null;
    private volatile V zzh = null;

    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ zzdv(String str, Object obj, Object obj2, zzdt zzdtVar, zzds zzdsVar) {
        this.zza = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zzb = zzdtVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zzb(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzdu.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzz.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzdv zzdvVar : zzdw.zzaC) {
                    if (zzz.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        zzdt<V> zzdtVar = zzdvVar.zzb;
                        if (zzdtVar != null) {
                            vZza = zzdtVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzdvVar.zzh = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzdt<V> zzdtVar2 = this.zzb;
            if (zzdtVar2 == null) {
                return this.zzc;
            }
            try {
                return zzdtVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzc;
            } catch (SecurityException unused4) {
                return this.zzc;
            }
        }
    }
}
