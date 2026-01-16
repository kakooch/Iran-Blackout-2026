package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import java.lang.Thread;

/* loaded from: classes3.dex */
final class C1 implements Thread.UncaughtExceptionHandler {
    private final String a;
    final /* synthetic */ F1 b;

    public C1(F1 f1, String str) {
        this.b = f1;
        AbstractC3795Cj5.j(str);
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.a.b().r().b(this.a, th);
    }
}
