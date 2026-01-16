package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;

/* renamed from: io.appmetrica.analytics.impl.gf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2567gf implements Runnable {
    public final File a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;

    public RunnableC2567gf(File file, Function function, Consumer consumer, Consumer consumer2) {
        this.a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.exists()) {
            try {
                Object objApply = this.b.apply(this.a);
                if (objApply != null) {
                    this.d.consume(objApply);
                }
            } catch (Throwable unused) {
            }
            this.c.consume(this.a);
        }
    }
}
