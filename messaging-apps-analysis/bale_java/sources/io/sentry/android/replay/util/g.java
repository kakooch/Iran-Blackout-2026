package io.sentry.android.replay.util;

import io.sentry.C3155n3;
import io.sentry.InterfaceC3097c0;
import io.sentry.Y2;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.C19938rB7;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class g {
    public static final void c(ExecutorService executorService, C3155n3 c3155n3) {
        AbstractC13042fc3.i(executorService, "<this>");
        AbstractC13042fc3.i(c3155n3, "options");
        synchronized (executorService) {
            if (!executorService.isShutdown()) {
                executorService.shutdown();
            }
            try {
            } catch (InterruptedException unused) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            if (executorService.awaitTermination(c3155n3.getShutdownTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                C19938rB7 c19938rB7 = C19938rB7.a;
            } else {
                executorService.shutdownNow();
                C19938rB7 c19938rB72 = C19938rB7.a;
            }
        }
    }

    public static final Future d(InterfaceC3097c0 interfaceC3097c0, final C3155n3 c3155n3, final String str, final Runnable runnable) {
        AbstractC13042fc3.i(interfaceC3097c0, "<this>");
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(str, "taskName");
        AbstractC13042fc3.i(runnable, "task");
        try {
            return interfaceC3097c0.submit(new Runnable() { // from class: io.sentry.android.replay.util.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.f(runnable, c3155n3, str);
                }
            });
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to submit task " + str + " to executor", th);
            return null;
        }
    }

    public static final Future e(ExecutorService executorService, final C3155n3 c3155n3, final String str, final Runnable runnable) {
        AbstractC13042fc3.i(executorService, "<this>");
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(str, "taskName");
        AbstractC13042fc3.i(runnable, "task");
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "currentThread().name");
        if (AbstractC20153rZ6.S(name, "SentryReplayIntegration", false, 2, null)) {
            runnable.run();
            return null;
        }
        try {
            return executorService.submit(new Runnable() { // from class: io.sentry.android.replay.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.g(runnable, c3155n3, str);
                }
            });
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to submit task " + str + " to executor", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Runnable runnable, C3155n3 c3155n3, String str) {
        AbstractC13042fc3.i(runnable, "$task");
        AbstractC13042fc3.i(c3155n3, "$options");
        AbstractC13042fc3.i(str, "$taskName");
        try {
            runnable.run();
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to execute task " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Runnable runnable, C3155n3 c3155n3, String str) {
        AbstractC13042fc3.i(runnable, "$task");
        AbstractC13042fc3.i(c3155n3, "$options");
        AbstractC13042fc3.i(str, "$taskName");
        try {
            runnable.run();
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to execute task " + str, th);
        }
    }
}
