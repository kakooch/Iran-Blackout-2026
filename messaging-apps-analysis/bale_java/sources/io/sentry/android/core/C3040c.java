package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import io.sentry.ILogger;
import io.sentry.Y2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.sentry.android.core.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3040c extends Thread {
    private final boolean a;
    private final a b;
    private final C3089z0 c;
    private final io.sentry.transport.p d;
    private long e;
    private final long f;
    private final ILogger g;
    private volatile long h;
    private final AtomicBoolean i;
    private final Context j;
    private final Runnable k;

    /* renamed from: io.sentry.android.core.c$a */
    public interface a {
        void a(ApplicationNotResponding applicationNotResponding);
    }

    C3040c(long j, boolean z, a aVar, ILogger iLogger, Context context) {
        this(new io.sentry.transport.p() { // from class: io.sentry.android.core.a
            @Override // io.sentry.transport.p
            public final long a() {
                return SystemClock.uptimeMillis();
            }
        }, j, 500L, z, aVar, iLogger, new C3089z0(), context);
    }

    private boolean c() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) this.j.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        try {
            processesInErrorState = activityManager.getProcessesInErrorState();
        } catch (Throwable th) {
            this.g.b(Y2.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
            processesInErrorState = null;
        }
        if (processesInErrorState == null) {
            return false;
        }
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (it.hasNext()) {
            if (it.next().condition == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(io.sentry.transport.p pVar) {
        this.h = pVar.a();
        this.i.set(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        this.k.run();
        while (!isInterrupted()) {
            this.c.b(this.k);
            try {
                Thread.sleep(this.e);
                if (this.d.a() - this.h > this.f) {
                    if (!this.a && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        this.g.c(Y2.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.i.set(true);
                    } else if (c() && this.i.compareAndSet(false, true)) {
                        this.b.a(new ApplicationNotResponding("Application Not Responding for at least " + this.f + " ms.", this.c.a()));
                    }
                }
            } catch (InterruptedException e) {
                try {
                    Thread.currentThread().interrupt();
                    this.g.c(Y2.WARNING, "Interrupted: %s", e.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.g.c(Y2.WARNING, "Failed to interrupt due to SecurityException: %s", e.getMessage());
                    return;
                }
            }
        }
    }

    C3040c(final io.sentry.transport.p pVar, long j, long j2, boolean z, a aVar, ILogger iLogger, C3089z0 c3089z0, Context context) {
        super("|ANR-WatchDog|");
        this.h = 0L;
        this.i = new AtomicBoolean(false);
        this.d = pVar;
        this.f = j;
        this.e = j2;
        this.a = z;
        this.b = aVar;
        this.g = iLogger;
        this.c = c3089z0;
        this.j = context;
        this.k = new Runnable() { // from class: io.sentry.android.core.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(pVar);
            }
        };
        if (j < this.e * 2) {
            throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", Long.valueOf(this.e * 2)));
        }
    }
}
