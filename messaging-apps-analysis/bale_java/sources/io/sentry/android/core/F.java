package io.sentry.android.core;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.A3;
import io.sentry.AbstractC3141l;
import io.sentry.C3115f3;
import io.sentry.C3148m1;
import io.sentry.ILogger;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.android.core.internal.util.C;
import io.sentry.util.C3202a;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class F {
    private final File b;
    private final int c;
    private String f;
    private final io.sentry.android.core.internal.util.C g;
    private final InterfaceC3097c0 l;
    private final ILogger m;
    private long a = 0;
    private Future d = null;
    private File e = null;
    private final ArrayDeque h = new ArrayDeque();
    private final ArrayDeque i = new ArrayDeque();
    private final ArrayDeque j = new ArrayDeque();
    private final Map k = new HashMap();
    private boolean n = false;
    protected final C3202a o = new C3202a();

    class a implements C.b {
        float a = 0.0f;

        a() {
        }

        @Override // io.sentry.android.core.internal.util.C.b
        public void e(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
            long jP = new C3115f3().p();
            long jNanoTime = ((j2 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - F.this.a;
            if (jNanoTime < 0) {
                return;
            }
            if (z2) {
                F.this.j.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j3), jP));
            } else if (z) {
                F.this.i.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j3), jP));
            }
            if (f != this.a) {
                this.a = f;
                F.this.h.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Float.valueOf(f), jP));
            }
        }
    }

    public static class b {
        public final long a;
        public final long b;
        public final File c;
        public final Map d;
        public final boolean e;

        public b(long j, long j2, boolean z, File file, Map map) {
            this.a = j;
            this.c = file;
            this.b = j2;
            this.d = map;
            this.e = z;
        }
    }

    public static class c {
        public final long a;
        public final long b;
        public final Date c;

        public c(long j, long j2, Date date) {
            this.a = j;
            this.b = j2;
            this.c = date;
        }
    }

    public F(String str, int i, io.sentry.android.core.internal.util.C c2, InterfaceC3097c0 interfaceC3097c0, ILogger iLogger) {
        this.b = new File((String) io.sentry.util.u.c(str, "TracesFilesDirPath is required"));
        this.c = i;
        this.m = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required");
        this.l = interfaceC3097c0;
        this.g = (io.sentry.android.core.internal.util.C) io.sentry.util.u.c(c2, "SentryFrameMetricsCollector is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        g(true, null);
    }

    private void i(List list) {
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.a) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            synchronized (list) {
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        C3148m1 c3148m1 = (C3148m1) it.next();
                        long jB = c3148m1.b();
                        long j = jB + jElapsedRealtimeNanos;
                        Double dA = c3148m1.a();
                        Long lC = c3148m1.c();
                        Long lD = c3148m1.d();
                        if (dA != null) {
                            arrayDeque3.add(new io.sentry.profilemeasurements.b(Long.valueOf(j), dA, jB));
                        }
                        if (lC != null) {
                            arrayDeque.add(new io.sentry.profilemeasurements.b(Long.valueOf(j), lC, jB));
                        }
                        if (lD != null) {
                            arrayDeque2.add(new io.sentry.profilemeasurements.b(Long.valueOf(j), lD, jB));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.k.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.k.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.k.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
        }
    }

    public void f() {
        InterfaceC3102d0 interfaceC3102d0A = this.o.a();
        try {
            Future future = this.d;
            if (future != null) {
                future.cancel(true);
                this.d = null;
            }
            if (this.n) {
                g(true, null);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #3 {all -> 0x001d, blocks: (B:3:0x0006, B:5:0x000c, B:12:0x0023, B:17:0x0031, B:19:0x0044, B:23:0x0055, B:26:0x005f, B:27:0x006d, B:29:0x0075, B:30:0x0083, B:32:0x008b, B:33:0x009b, B:35:0x00a2, B:36:0x00a8, B:41:0x00ba, B:42:0x00bc, B:11:0x0020, B:15:0x0027), top: B:55:0x0006, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: all -> 0x001d, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x001d, blocks: (B:3:0x0006, B:5:0x000c, B:12:0x0023, B:17:0x0031, B:19:0x0044, B:23:0x0055, B:26:0x005f, B:27:0x006d, B:29:0x0075, B:30:0x0083, B:32:0x008b, B:33:0x009b, B:35:0x00a2, B:36:0x00a8, B:41:0x00ba, B:42:0x00bc, B:11:0x0020, B:15:0x0027), top: B:55:0x0006, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.android.core.F.b g(boolean r14, java.util.List r15) {
        /*
            r13 = this;
            io.sentry.util.a r0 = r13.o
            io.sentry.d0 r0 = r0.a()
            boolean r1 = r13.n     // Catch: java.lang.Throwable -> L1d
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L20
            io.sentry.ILogger r14 = r13.m     // Catch: java.lang.Throwable -> L1d
            io.sentry.Y2 r15 = io.sentry.Y2.WARNING     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = "Profiler not running"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1d
            r14.c(r15, r1, r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.close()
        L1c:
            return r2
        L1d:
            r14 = move-exception
            goto Lbd
        L20:
            android.os.Debug.stopMethodTracing()     // Catch: java.lang.Throwable -> L26
        L23:
            r13.n = r3     // Catch: java.lang.Throwable -> L1d
            goto L31
        L26:
            r1 = move-exception
            io.sentry.ILogger r4 = r13.m     // Catch: java.lang.Throwable -> Lb9
            io.sentry.Y2 r5 = io.sentry.Y2.ERROR     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r6 = "Error while stopping profiling: "
            r4.b(r5, r6, r1)     // Catch: java.lang.Throwable -> Lb9
            goto L23
        L31:
            io.sentry.android.core.internal.util.C r1 = r13.g     // Catch: java.lang.Throwable -> L1d
            java.lang.String r4 = r13.f     // Catch: java.lang.Throwable -> L1d
            r1.r(r4)     // Catch: java.lang.Throwable -> L1d
            long r6 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L1d
            long r8 = android.os.Process.getElapsedCpuTime()     // Catch: java.lang.Throwable -> L1d
            java.io.File r1 = r13.e     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L55
            io.sentry.ILogger r14 = r13.m     // Catch: java.lang.Throwable -> L1d
            io.sentry.Y2 r15 = io.sentry.Y2.ERROR     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = "Trace file does not exists"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1d
            r14.c(r15, r1, r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L54
            r0.close()
        L54:
            return r2
        L55:
            java.util.ArrayDeque r1 = r13.i     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "nanosecond"
            if (r1 != 0) goto L6d
            java.util.Map r1 = r13.k     // Catch: java.lang.Throwable -> L1d
            java.lang.String r4 = "slow_frame_renders"
            io.sentry.profilemeasurements.a r5 = new io.sentry.profilemeasurements.a     // Catch: java.lang.Throwable -> L1d
            java.util.ArrayDeque r10 = r13.i     // Catch: java.lang.Throwable -> L1d
            r5.<init>(r3, r10)     // Catch: java.lang.Throwable -> L1d
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L1d
        L6d:
            java.util.ArrayDeque r1 = r13.j     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L83
            java.util.Map r1 = r13.k     // Catch: java.lang.Throwable -> L1d
            java.lang.String r4 = "frozen_frame_renders"
            io.sentry.profilemeasurements.a r5 = new io.sentry.profilemeasurements.a     // Catch: java.lang.Throwable -> L1d
            java.util.ArrayDeque r10 = r13.j     // Catch: java.lang.Throwable -> L1d
            r5.<init>(r3, r10)     // Catch: java.lang.Throwable -> L1d
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L1d
        L83:
            java.util.ArrayDeque r1 = r13.h     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L9b
            java.util.Map r1 = r13.k     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "screen_frame_rates"
            io.sentry.profilemeasurements.a r4 = new io.sentry.profilemeasurements.a     // Catch: java.lang.Throwable -> L1d
            java.lang.String r5 = "hz"
            java.util.ArrayDeque r10 = r13.h     // Catch: java.lang.Throwable -> L1d
            r4.<init>(r5, r10)     // Catch: java.lang.Throwable -> L1d
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L1d
        L9b:
            r13.i(r15)     // Catch: java.lang.Throwable -> L1d
            java.util.concurrent.Future r15 = r13.d     // Catch: java.lang.Throwable -> L1d
            if (r15 == 0) goto La8
            r1 = 1
            r15.cancel(r1)     // Catch: java.lang.Throwable -> L1d
            r13.d = r2     // Catch: java.lang.Throwable -> L1d
        La8:
            io.sentry.android.core.F$b r15 = new io.sentry.android.core.F$b     // Catch: java.lang.Throwable -> L1d
            java.io.File r11 = r13.e     // Catch: java.lang.Throwable -> L1d
            java.util.Map r12 = r13.k     // Catch: java.lang.Throwable -> L1d
            r5 = r15
            r10 = r14
            r5.<init>(r6, r8, r10, r11, r12)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto Lb8
            r0.close()
        Lb8:
            return r15
        Lb9:
            r14 = move-exception
            r13.n = r3     // Catch: java.lang.Throwable -> L1d
            throw r14     // Catch: java.lang.Throwable -> L1d
        Lbd:
            if (r0 == 0) goto Lc7
            r0.close()     // Catch: java.lang.Throwable -> Lc3
            goto Lc7
        Lc3:
            r15 = move-exception
            r14.addSuppressed(r15)
        Lc7:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.F.g(boolean, java.util.List):io.sentry.android.core.F$b");
    }

    public c j() {
        InterfaceC3102d0 interfaceC3102d0A = this.o.a();
        try {
            int i = this.c;
            if (i == 0) {
                this.m.c(Y2.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i));
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return null;
            }
            if (this.n) {
                this.m.c(Y2.WARNING, "Profiling has already started...", new Object[0]);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return null;
            }
            this.e = new File(this.b, A3.a() + ".trace");
            this.k.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.f = this.g.q(new a());
            try {
                InterfaceC3097c0 interfaceC3097c0 = this.l;
                if (interfaceC3097c0 != null) {
                    this.d = interfaceC3097c0.c(new Runnable() { // from class: io.sentry.android.core.E
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.h();
                        }
                    }, 30000L);
                }
            } catch (RejectedExecutionException e) {
                this.m.b(Y2.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e);
            }
            this.a = SystemClock.elapsedRealtimeNanos();
            Date dateD = AbstractC3141l.d();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            try {
                Debug.startMethodTracingSampling(this.e.getPath(), 3000000, this.c);
                this.n = true;
                c cVar = new c(this.a, elapsedCpuTime, dateD);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return cVar;
            } catch (Throwable th) {
                g(false, null);
                this.m.b(Y2.ERROR, "Unable to start a profile: ", th);
                this.n = false;
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return null;
            }
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
