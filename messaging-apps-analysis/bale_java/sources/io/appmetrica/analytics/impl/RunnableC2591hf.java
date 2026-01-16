package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;

/* renamed from: io.appmetrica.analytics.impl.hf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2591hf implements Runnable {
    public final File a;
    public final Consumer b;
    public final T9 c;

    public RunnableC2591hf(File file, A1 a1, T9 t9) {
        this.a = file;
        this.b = a1;
        this.c = t9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] fileArrListFiles;
        if (this.a.exists() && this.a.isDirectory() && (fileArrListFiles = this.a.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                C2800q9 c2800q9A = this.c.a(file.getName());
                try {
                    c2800q9A.a.lock();
                    c2800q9A.b.a();
                    this.b.consume(file);
                    c2800q9A.c();
                } catch (Throwable unused) {
                    c2800q9A.c();
                }
            }
        }
    }
}
