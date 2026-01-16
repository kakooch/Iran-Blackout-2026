package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;

/* renamed from: io.appmetrica.analytics.impl.s9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2847s9 implements ExecutorProvider {
    public final C2881tj a;
    public final IHandlerExecutor b;

    public C2847s9() {
        C2881tj c2881tjU = C2586ha.h().u();
        this.a = c2881tjU;
        this.b = c2881tjU.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + "-" + Zc.a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C2881tj c2881tj = this.a;
        if (c2881tj.f == null) {
            synchronized (c2881tj) {
                try {
                    if (c2881tj.f == null) {
                        c2881tj.a.getClass();
                        Ua uaA = C2871t9.a("IAA-SIO");
                        c2881tj.f = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return c2881tj.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.a.f();
    }
}
