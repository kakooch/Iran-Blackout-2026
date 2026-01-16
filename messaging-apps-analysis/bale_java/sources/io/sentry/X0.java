package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
final class X0 implements InterfaceC3097c0 {
    private static final X0 a = new X0();

    private X0() {
    }

    public static InterfaceC3097c0 f() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object h() {
        return null;
    }

    @Override // io.sentry.InterfaceC3097c0
    public void a() {
    }

    @Override // io.sentry.InterfaceC3097c0
    public void b(long j) {
    }

    @Override // io.sentry.InterfaceC3097c0
    public Future c(Runnable runnable, long j) {
        return new FutureTask(new Callable() { // from class: io.sentry.V0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return X0.g();
            }
        });
    }

    @Override // io.sentry.InterfaceC3097c0
    public boolean isClosed() {
        return false;
    }

    @Override // io.sentry.InterfaceC3097c0
    public Future submit(Runnable runnable) {
        return new FutureTask(new Callable() { // from class: io.sentry.W0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return X0.h();
            }
        });
    }
}
