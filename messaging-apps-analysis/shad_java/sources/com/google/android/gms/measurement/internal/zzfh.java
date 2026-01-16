package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfh extends Thread {
    final /* synthetic */ zzfi zza;
    private final Object zzb;
    private final BlockingQueue<zzfg<?>> zzc;
    private boolean zzd = false;

    public zzfh(zzfi zzfiVar, String str, BlockingQueue<zzfg<?>> blockingQueue) {
        this.zza = zzfiVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zza.zzg) {
            if (!this.zzd) {
                this.zza.zzh.release();
                this.zza.zzg.notifyAll();
                if (this == this.zza.zza) {
                    zzfi.zzp(this.zza, null);
                } else if (this == this.zza.zzb) {
                    zzfi.zzr(this.zza, null);
                } else {
                    this.zza.zzx.zzat().zzb().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzd = true;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzx.zzat().zze().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzh.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfg<?> zzfgVarPoll = this.zzc.poll();
                if (zzfgVarPoll == null) {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            zzfi.zzm(this.zza);
                            try {
                                this.zzb.wait(30000L);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    synchronized (this.zza.zzg) {
                        if (this.zzc.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(true != zzfgVarPoll.zza ? 10 : threadPriority);
                    zzfgVarPoll.run();
                }
            }
            if (this.zza.zzx.zzc().zzn(null, zzdw.zzap)) {
                zzb();
            }
        } finally {
            zzb();
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
