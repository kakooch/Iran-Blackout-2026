package io.sentry.android.core;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.AbstractC3141l;
import io.sentry.C3091b;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3157o0;
import io.sentry.L2;
import io.sentry.Y2;
import io.sentry.protocol.C3169d;
import ir.nasim.AbstractC9406Zu2;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AnrV2Integration implements InterfaceC3157o0, Closeable {
    static final long d = TimeUnit.DAYS.toMillis(91);
    private final Context a;
    private final io.sentry.transport.p b;
    private SentryAndroidOptions c;

    static class a implements Runnable {
        private final Context a;
        private final io.sentry.Z b;
        private final SentryAndroidOptions c;
        private final long d;

        a(Context context, io.sentry.Z z, SentryAndroidOptions sentryAndroidOptions, io.sentry.transport.p pVar) {
            this.a = context;
            this.b = z;
            this.c = sentryAndroidOptions;
            this.d = pVar.a() - AnrV2Integration.d;
        }

        private byte[] a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr, 0, 1024);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        private c b(ApplicationExitInfo applicationExitInfo, boolean z) {
            try {
                InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                try {
                    if (traceInputStream == null) {
                        c cVar = new c(c.a.NO_DUMP);
                        if (traceInputStream != null) {
                            traceInputStream.close();
                        }
                        return cVar;
                    }
                    byte[] bArrA = a(traceInputStream);
                    traceInputStream.close();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArrA)));
                        try {
                            io.sentry.android.core.internal.threaddump.b bVarC = io.sentry.android.core.internal.threaddump.b.c(bufferedReader);
                            io.sentry.android.core.internal.threaddump.c cVar2 = new io.sentry.android.core.internal.threaddump.c(this.c, z);
                            cVar2.i(bVarC);
                            List listF = cVar2.f();
                            List listC = cVar2.c();
                            if (listF.isEmpty()) {
                                c cVar3 = new c(c.a.NO_DUMP);
                                bufferedReader.close();
                                return cVar3;
                            }
                            c cVar4 = new c(c.a.DUMP, bArrA, listF, listC);
                            bufferedReader.close();
                            return cVar4;
                        } finally {
                        }
                    } catch (Throwable th) {
                        this.c.getLogger().b(Y2.WARNING, "Failed to parse ANR thread dump", th);
                        return new c(c.a.ERROR, bArrA);
                    }
                } finally {
                }
            } catch (Throwable th2) {
                this.c.getLogger().b(Y2.WARNING, "Failed to read ANR thread dump", th2);
                return new c(c.a.NO_DUMP);
            }
        }

        private void c(ApplicationExitInfo applicationExitInfo, boolean z) {
            byte[] bArr;
            long timestamp = applicationExitInfo.getTimestamp();
            boolean z2 = applicationExitInfo.getImportance() != 100;
            c cVarB = b(applicationExitInfo, z2);
            if (cVarB.a == c.a.NO_DUMP) {
                this.c.getLogger().c(Y2.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
                return;
            }
            b bVar = new b(this.c.getFlushTimeoutMillis(), this.c.getLogger(), timestamp, z, z2);
            io.sentry.I iE = io.sentry.util.m.e(bVar);
            L2 l2 = new L2();
            c.a aVar = cVarB.a;
            if (aVar == c.a.ERROR) {
                io.sentry.protocol.k kVar = new io.sentry.protocol.k();
                kVar.f("Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.");
                l2.E0(kVar);
            } else if (aVar == c.a.DUMP) {
                l2.G0(cVarB.c);
                if (cVarB.d != null) {
                    C3169d c3169d = new C3169d();
                    c3169d.e(cVarB.d);
                    l2.T(c3169d);
                }
            }
            l2.D0(Y2.FATAL);
            l2.H0(AbstractC3141l.e(timestamp));
            if (this.c.isAttachAnrThreadDump() && (bArr = cVarB.b) != null) {
                iE.n(C3091b.b(bArr));
            }
            if (this.b.I(l2, iE).equals(io.sentry.protocol.v.b) || bVar.g()) {
                return;
            }
            this.c.getLogger().c(Y2.WARNING, "Timed out waiting to flush ANR event to disk. Event: %s", l2.G());
        }

        private void d(List list, Long l) {
            Collections.reverse(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ApplicationExitInfo applicationExitInfoA = AbstractC9406Zu2.a(it.next());
                if (applicationExitInfoA.getReason() == 6) {
                    if (applicationExitInfoA.getTimestamp() < this.d) {
                        this.c.getLogger().c(Y2.DEBUG, "ANR happened too long ago %s.", applicationExitInfoA);
                    } else if (l == null || applicationExitInfoA.getTimestamp() > l.longValue()) {
                        c(applicationExitInfoA, false);
                    } else {
                        this.c.getLogger().c(Y2.DEBUG, "ANR has already been reported %s.", applicationExitInfoA);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ApplicationExitInfo applicationExitInfo = null;
            List historicalProcessExitReasons = ((ActivityManager) this.a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() == 0) {
                this.c.getLogger().c(Y2.DEBUG, "No records in historical exit reasons.", new Object[0]);
                return;
            }
            io.sentry.cache.g envelopeDiskCache = this.c.getEnvelopeDiskCache();
            if ((envelopeDiskCache instanceof io.sentry.cache.f) && this.c.isEnableAutoSessionTracking()) {
                io.sentry.cache.f fVar = (io.sentry.cache.f) envelopeDiskCache;
                if (!fVar.a0()) {
                    this.c.getLogger().c(Y2.WARNING, "Timed out waiting to flush previous session to its own file.", new Object[0]);
                    fVar.O();
                }
            }
            ArrayList arrayList = new ArrayList(historicalProcessExitReasons);
            Long lI0 = io.sentry.android.core.cache.b.i0(this.c);
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ApplicationExitInfo applicationExitInfoA = AbstractC9406Zu2.a(it.next());
                if (applicationExitInfoA.getReason() == 6) {
                    arrayList.remove(applicationExitInfoA);
                    applicationExitInfo = applicationExitInfoA;
                    break;
                }
            }
            if (applicationExitInfo == null) {
                this.c.getLogger().c(Y2.DEBUG, "No ANRs have been found in the historical exit reasons list.", new Object[0]);
                return;
            }
            if (applicationExitInfo.getTimestamp() < this.d) {
                this.c.getLogger().c(Y2.DEBUG, "Latest ANR happened too long ago, returning early.", new Object[0]);
                return;
            }
            if (lI0 != null && applicationExitInfo.getTimestamp() <= lI0.longValue()) {
                this.c.getLogger().c(Y2.DEBUG, "Latest ANR has already been reported, returning early.", new Object[0]);
                return;
            }
            if (this.c.isReportHistoricalAnrs()) {
                d(arrayList, lI0);
            }
            c(applicationExitInfo, true);
        }
    }

    public static final class b extends io.sentry.hints.d implements io.sentry.hints.c, io.sentry.hints.a {
        private final long d;
        private final boolean e;
        private final boolean f;

        public b(long j, ILogger iLogger, long j2, boolean z, boolean z2) {
            super(j, iLogger);
            this.d = j2;
            this.e = z;
            this.f = z2;
        }

        @Override // io.sentry.hints.c
        public boolean a() {
            return this.e;
        }

        @Override // io.sentry.hints.f
        public boolean b(io.sentry.protocol.v vVar) {
            return true;
        }

        @Override // io.sentry.hints.f
        public void c(io.sentry.protocol.v vVar) {
        }

        @Override // io.sentry.hints.a
        public Long e() {
            return Long.valueOf(this.d);
        }

        @Override // io.sentry.hints.a
        public boolean f() {
            return false;
        }

        @Override // io.sentry.hints.a
        public String h() {
            return this.f ? "anr_background" : "anr_foreground";
        }
    }

    public AnrV2Integration(Context context) {
        this(context, io.sentry.transport.n.b());
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.c = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(this.c.isAnrEnabled()));
        if (this.c.getCacheDirPath() == null) {
            this.c.getLogger().c(Y2.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (this.c.isAnrEnabled()) {
            try {
                c3155n3.getExecutorService().submit(new a(this.a, z, this.c, this.b));
            } catch (Throwable th) {
                c3155n3.getLogger().b(Y2.DEBUG, "Failed to start AnrProcessor.", th);
            }
            c3155n3.getLogger().c(Y2.DEBUG, "AnrV2Integration installed.", new Object[0]);
            io.sentry.util.o.a("AnrV2");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SentryAndroidOptions sentryAndroidOptions = this.c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(Y2.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }

    AnrV2Integration(Context context, io.sentry.transport.p pVar) {
        this.a = AbstractC3060k0.g(context);
        this.b = pVar;
    }

    static final class c {
        final a a;
        final byte[] b;
        final List c;
        final List d;

        enum a {
            DUMP,
            NO_DUMP,
            ERROR
        }

        c(a aVar) {
            this.a = aVar;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        c(a aVar, byte[] bArr) {
            this.a = aVar;
            this.b = bArr;
            this.c = null;
            this.d = null;
        }

        c(a aVar, byte[] bArr, List list, List list2) {
            this.a = aVar;
            this.b = bArr;
            this.c = list;
            this.d = list2;
        }
    }
}
