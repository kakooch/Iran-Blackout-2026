package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfg<V> extends FutureTask<V> implements Comparable<zzfg<V>> {
    final boolean zza;
    final /* synthetic */ zzfi zzb;
    private final long zzc;
    private final String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfg(zzfi zzfiVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzb = zzfiVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfi.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfiVar.zzx.zzat().zzb().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfg zzfgVar = (zzfg) obj;
        boolean z = this.zza;
        if (z != zzfgVar.zza) {
            return !z ? 1 : -1;
        }
        long j = this.zzc;
        long j2 = zzfgVar.zzc;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzb.zzx.zzat().zzc().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzb.zzx.zzat().zzb().zzb(this.zzd, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfg(zzfi zzfiVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzb = zzfiVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfi.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfiVar.zzx.zzat().zzb().zza("Tasks index overflow");
        }
    }
}
