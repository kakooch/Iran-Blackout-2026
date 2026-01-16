package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* renamed from: io.appmetrica.analytics.impl.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2647k0 implements InterfaceC2920va {
    public final Handler a;
    public final IHandlerExecutor b;
    public final C2771p4 c;

    public C2647k0() {
        IHandlerExecutor iHandlerExecutorA = C2747o4.g().d().a();
        this.b = iHandlerExecutorA;
        this.a = iHandlerExecutorA.getHandler();
        this.c = new C2771p4();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final void a(AppMetricaConfig appMetricaConfig, Na na) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final Handler b() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final T1 c() {
        return new T1();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final C2465cb d() {
        return new C2465cb();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final ICommonExecutor getDefaultExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2920va
    public final C2771p4 a() {
        return this.c;
    }
}
