package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class P1 implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean e = new AtomicBoolean();
    public final InterfaceC3016za a;
    public final Sb b = C2747o4.g().j();
    public final C2725n6 c = new C2725n6();
    public final C3028zm d = new C3028zm();

    public P1(C2653k6 c2653k6) {
        this.a = c2653k6;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace;
        try {
            e.set(true);
            InterfaceC3016za interfaceC3016za = this.a;
            C2860sm c2860smApply = this.c.apply(thread);
            C3028zm c3028zm = this.d;
            Thread threadA = ((C2956wm) c3028zm.a).a();
            ArrayList arrayListA = c3028zm.a(threadA, thread);
            if (thread != threadA) {
                try {
                    stackTrace = threadA.getStackTrace();
                } catch (SecurityException unused) {
                    stackTrace = null;
                }
                arrayListA.add(0, (C2860sm) c3028zm.b.apply(threadA, stackTrace));
            }
            interfaceC3016za.a(th, new T(c2860smApply, arrayListA, this.b.b()));
        } catch (Throwable th2) {
            LoggerStorage.getMainPublicOrAnonymousLogger().error(th2, th2.getMessage(), new Object[0]);
        }
    }
}
