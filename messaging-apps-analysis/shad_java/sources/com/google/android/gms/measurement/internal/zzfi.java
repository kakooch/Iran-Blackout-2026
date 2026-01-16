package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfi extends zzgf {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzfh zza;
    private zzfh zzb;
    private final PriorityBlockingQueue<zzfg<?>> zzc;
    private final BlockingQueue<zzfg<?>> zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    zzfi(zzfl zzflVar) {
        super(zzflVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue<>();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzff(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzff(this, "Thread death: Uncaught exception on network thread");
    }

    static /* synthetic */ boolean zzm(zzfi zzfiVar) {
        boolean z = zzfiVar.zzi;
        return false;
    }

    static /* synthetic */ zzfh zzp(zzfi zzfiVar, zzfh zzfhVar) {
        zzfiVar.zza = null;
        return null;
    }

    static /* synthetic */ zzfh zzr(zzfi zzfiVar, zzfh zzfhVar) {
        zzfiVar.zzb = null;
        return null;
    }

    private final void zzt(zzfg<?> zzfgVar) {
        synchronized (this.zzg) {
            this.zzc.add(zzfgVar);
            zzfh zzfhVar = this.zza;
            if (zzfhVar == null) {
                zzfh zzfhVar2 = new zzfh(this, "Measurement Worker", this.zzc);
                this.zza = zzfhVar2;
                zzfhVar2.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                zzfhVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzge
    public final void zzav() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzd() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfg<?> zzfgVar = new zzfg<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                this.zzx.zzat().zze().zza("Callable skipped the worker queue.");
            }
            zzfgVar.run();
        } else {
            zzt(zzfgVar);
        }
        return zzfgVar;
    }

    public final <V> Future<V> zzf(Callable<V> callable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(callable);
        zzfg<?> zzfgVar = new zzfg<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfgVar.run();
        } else {
            zzt(zzfgVar);
        }
        return zzfgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzge
    public final void zzg() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zzh(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfg<>(this, runnable, false, "Task exception on worker thread"));
    }

    final <T> T zzi(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.zzx.zzau().zzh(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                this.zzx.zzat().zze().zza(str.length() != 0 ? "Interrupted waiting for ".concat(str) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            this.zzx.zzat().zze().zza(str.length() != 0 ? "Timed out waiting for ".concat(str) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final void zzj(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfg<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final void zzk(Runnable runnable) throws IllegalStateException {
        zzv();
        Preconditions.checkNotNull(runnable);
        zzfg<?> zzfgVar = new zzfg<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzfgVar);
            zzfh zzfhVar = this.zzb;
            if (zzfhVar == null) {
                zzfh zzfhVar2 = new zzfh(this, "Measurement Network", this.zzd);
                this.zzb = zzfhVar2;
                zzfhVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzfhVar.zza();
            }
        }
    }
}
