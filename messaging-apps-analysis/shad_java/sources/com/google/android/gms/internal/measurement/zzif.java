package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public class zzif {
    protected volatile zzix zza;
    private volatile zzgs zzc;

    static {
        zzhe.zza();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzifVar = (zzif) obj;
        zzix zzixVar = this.zza;
        zzix zzixVar2 = zzifVar.zza;
        if (zzixVar == null && zzixVar2 == null) {
            return zzb().equals(zzifVar.zzb());
        }
        if (zzixVar != null && zzixVar2 != null) {
            return zzixVar.equals(zzixVar2);
        }
        if (zzixVar != null) {
            zzifVar.zzc(zzixVar.zzbK());
            return zzixVar.equals(zzifVar.zza);
        }
        zzc(zzixVar2.zzbK());
        return this.zza.equals(zzixVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgq) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    public final zzgs zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzgs.zzb;
            } else {
                this.zzc = this.zza.zzbo();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzix zzixVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzixVar;
                    this.zzc = zzgs.zzb;
                } catch (zzic unused) {
                    this.zza = zzixVar;
                    this.zzc = zzgs.zzb;
                }
            }
        }
    }
}
