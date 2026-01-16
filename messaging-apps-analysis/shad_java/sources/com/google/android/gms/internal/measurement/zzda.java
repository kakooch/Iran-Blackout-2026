package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzda extends zzho<zzdb, zzda> implements zziy {
    private zzda() {
        super(zzdb.zzj);
    }

    /* synthetic */ zzda(zzcs zzcsVar) {
        super(zzdb.zzj);
    }

    public final List<zzdf> zza() {
        return Collections.unmodifiableList(((zzdb) this.zza).zza());
    }

    public final int zzb() {
        return ((zzdb) this.zza).zzb();
    }

    public final zzdf zzc(int i) {
        return ((zzdb) this.zza).zzc(i);
    }

    public final zzda zzd(int i, zzdf zzdfVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzn((zzdb) this.zza, i, zzdfVar);
        return this;
    }

    public final zzda zze(int i, zzde zzdeVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzn((zzdb) this.zza, i, zzdeVar.zzaA());
        return this;
    }

    public final zzda zzf(zzdf zzdfVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzo((zzdb) this.zza, zzdfVar);
        return this;
    }

    public final zzda zzg(zzde zzdeVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzo((zzdb) this.zza, zzdeVar.zzaA());
        return this;
    }

    public final zzda zzh(Iterable<? extends zzdf> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzp((zzdb) this.zza, iterable);
        return this;
    }

    public final zzda zzi() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        ((zzdb) this.zza).zze = zzhs.zzbE();
        return this;
    }

    public final zzda zzj(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzr((zzdb) this.zza, i);
        return this;
    }

    public final String zzk() {
        return ((zzdb) this.zza).zzd();
    }

    public final zzda zzl(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzs((zzdb) this.zza, str);
        return this;
    }

    public final boolean zzm() {
        return ((zzdb) this.zza).zze();
    }

    public final long zzn() {
        return ((zzdb) this.zza).zzf();
    }

    public final zzda zzo(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzt((zzdb) this.zza, j);
        return this;
    }

    public final long zzp() {
        return ((zzdb) this.zza).zzh();
    }

    public final zzda zzq(long j) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzdb.zzu((zzdb) this.zza, j);
        return this;
    }
}
