package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.A3;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.android.core.Y;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class C implements Application.ActivityLifecycleCallbacks {
    private static final long n = TimeUnit.SECONDS.toNanos(1);
    private static final long o = TimeUnit.MILLISECONDS.toNanos(700);
    private final Y a;
    private final Set b;
    private final ILogger c;
    private Handler d;
    private WeakReference e;
    private final Map f;
    private boolean g;
    private final c h;
    private Window.OnFrameMetricsAvailableListener i;
    private Choreographer j;
    private Field k;
    private long l;
    private long m;

    class a implements c {
        a() {
        }
    }

    public interface b {
        void e(long j, long j2, long j3, long j4, boolean z, boolean z2, float f);
    }

    public interface c {
        default void a(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
            if (onFrameMetricsAvailableListener == null) {
                return;
            }
            window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
        }

        default void b(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
            if (onFrameMetricsAvailableListener == null) {
                return;
            }
            window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }

    public C(Context context, ILogger iLogger, Y y) {
        this(context, iLogger, y, new a());
    }

    private long f(FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }

    private long g(FrameMetrics frameMetrics) {
        return this.a.d() >= 26 ? frameMetrics.getMetric(10) : h();
    }

    public static boolean i(long j) {
        return j > o;
    }

    public static boolean j(long j, long j2) {
        return j > j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(ILogger iLogger, Thread thread, Throwable th) {
        iLogger.b(Y2.ERROR, "Error during frames measurements.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ILogger iLogger) {
        try {
            this.j = Choreographer.getInstance();
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Y y, Window window, FrameMetrics frameMetrics, int i) {
        long jNanoTime = System.nanoTime();
        float refreshRate = y.d() >= 30 ? window.getContext().getDisplay().getRefreshRate() : window.getWindowManager().getDefaultDisplay().getRefreshRate();
        long j = n;
        long jF = f(frameMetrics);
        long jMax = Math.max(0L, jF - ((long) (j / refreshRate)));
        long jG = g(frameMetrics);
        if (jG < 0) {
            jG = jNanoTime - jF;
        }
        long jMax2 = Math.max(jG, this.m);
        if (jMax2 == this.l) {
            return;
        }
        this.l = jMax2;
        this.m = jMax2 + jF;
        boolean zJ = j(jF, (long) (j / (refreshRate - 1.0f)));
        boolean z = zJ && i(jF);
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).e(jMax2, this.m, jF, jMax, zJ, z, refreshRate);
            jF = jF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Window window) {
        try {
            if (this.b.remove(window)) {
                this.h.b(window, this.i);
            }
        } catch (Throwable th) {
            this.c.b(Y2.ERROR, "Failed to remove frameMetricsAvailableListener", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Window window) {
        if (this.b.add(window)) {
            try {
                this.h.a(window, this.i, this.d);
            } catch (Throwable th) {
                this.c.b(Y2.ERROR, "Failed to add frameMetricsAvailableListener", th);
            }
        }
    }

    private void p(Window window) {
        WeakReference weakReference = this.e;
        if (weakReference == null || weakReference.get() != window) {
            this.e = new WeakReference(window);
            t();
        }
    }

    private void s(final Window window) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.y
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(window);
            }
        });
    }

    private void t() {
        WeakReference weakReference = this.e;
        final Window window = weakReference != null ? (Window) weakReference.get() : null;
        if (window == null || !this.g || this.f.isEmpty() || this.d == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.x
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(window);
            }
        });
    }

    public long h() {
        Field field;
        Choreographer choreographer = this.j;
        if (choreographer == null || (field = this.k) == null) {
            return -1L;
        }
        try {
            Long l = (Long) field.get(choreographer);
            if (l != null) {
                return l.longValue();
            }
            return -1L;
        } catch (IllegalAccessException unused) {
            return -1L;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        p(activity.getWindow());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        s(activity.getWindow());
        WeakReference weakReference = this.e;
        if (weakReference == null || weakReference.get() != activity.getWindow()) {
            return;
        }
        this.e = null;
    }

    public String q(b bVar) {
        if (!this.g) {
            return null;
        }
        String strA = A3.a();
        this.f.put(strA, bVar);
        t();
        return strA;
    }

    public void r(String str) {
        if (this.g) {
            if (str != null) {
                this.f.remove(str);
            }
            WeakReference weakReference = this.e;
            Window window = weakReference != null ? (Window) weakReference.get() : null;
            if (window == null || !this.f.isEmpty()) {
                return;
            }
            s(window);
        }
    }

    public C(Context context, final ILogger iLogger, final Y y, c cVar) throws NoSuchFieldException, SecurityException {
        this.b = new CopyOnWriteArraySet();
        this.f = new ConcurrentHashMap();
        this.g = false;
        this.l = 0L;
        this.m = 0L;
        Context context2 = (Context) io.sentry.util.u.c(AbstractC3060k0.g(context), "The context is required");
        this.c = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required");
        this.a = (Y) io.sentry.util.u.c(y, "BuildInfoProvider is required");
        this.h = (c) io.sentry.util.u.c(cVar, "WindowFrameMetricsManager is required");
        if ((context2 instanceof Application) && y.d() >= 24) {
            this.g = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.sentry.android.core.internal.util.z
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    C.k(iLogger, thread, th);
                }
            });
            handlerThread.start();
            this.d = new Handler(handlerThread.getLooper());
            ((Application) context2).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(iLogger);
                }
            });
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.k = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                iLogger.b(Y2.ERROR, "Unable to get the frame timestamp from the choreographer: ", e);
            }
            this.i = new Window.OnFrameMetricsAvailableListener() { // from class: io.sentry.android.core.internal.util.B
                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                    this.a.m(y, window, frameMetrics, i);
                }
            };
        }
    }
}
