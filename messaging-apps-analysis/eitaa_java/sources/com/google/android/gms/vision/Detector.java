package com.google.android.gms.vision;

import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public abstract class Detector<T> {
    private final Object zzad = new Object();

    @GuardedBy("processorLock")
    private Processor<T> zzae;

    public interface Processor<T> {
        void release();
    }

    public void release() {
        synchronized (this.zzad) {
            Processor<T> processor = this.zzae;
            if (processor != null) {
                processor.release();
                this.zzae = null;
            }
        }
    }
}
