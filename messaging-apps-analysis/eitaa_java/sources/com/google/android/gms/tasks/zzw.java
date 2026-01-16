package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes.dex */
final class zzw<TResult> extends Task<TResult> {
    private final Object zza = new Object();
    private final zzr zzb = new zzr();

    @GuardedBy("mLock")
    private boolean zzc;
    private volatile boolean zzd;

    @GuardedBy("mLock")
    private Object zze;

    @GuardedBy("mLock")
    private Exception zzf;

    zzw() {
    }

    @GuardedBy("mLock")
    private final void zzf() {
        Preconditions.checkState(this.zzc, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void zzg() {
        if (this.zzd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @GuardedBy("mLock")
    private final void zzh() {
        if (this.zzc) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    private final void zzi() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zzb(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            zzf();
            zzg();
            Exception exc = this.zzf;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.zze;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.zzd;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzc && !this.zzd && this.zzf == null) {
                z = true;
            }
        }
        return z;
    }

    public final void zza(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb(this);
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb(this);
    }

    public final boolean zzc() {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zzd(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exc;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zze(Object obj) {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = obj;
            this.zzb.zzb(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(executor, onCompleteListener));
        zzi();
        return this;
    }
}
