package io.sentry.android.core;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.C3148m1;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.util.AbstractC3209h;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/* renamed from: io.sentry.android.core.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3080v implements io.sentry.W {
    private final ILogger h;
    private long a = 0;
    private long b = 0;
    private long c = 1;
    private long d = 1;
    private final long e = 1000000000;
    private double f = 1.0E9d / 1;
    private final File g = new File("/proc/self/stat");
    private boolean i = false;
    private final Pattern j = Pattern.compile("[\n\t\r ]");

    public C3080v(ILogger iLogger) {
        this.h = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required.");
    }

    private long e() throws NumberFormatException {
        String strC;
        try {
            strC = AbstractC3209h.c(this.g);
        } catch (IOException e) {
            this.i = false;
            this.h.b(Y2.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e);
            strC = null;
        }
        if (strC != null) {
            String[] strArrSplit = this.j.split(strC.trim());
            try {
                long j = Long.parseLong(strArrSplit[13]);
                long j2 = Long.parseLong(strArrSplit[14]);
                return (long) ((j + j2 + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16])) * this.f);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e2) {
                this.h.b(Y2.ERROR, "Error parsing /proc/self/stat file.", e2);
            }
        }
        return 0L;
    }

    @Override // io.sentry.W
    public void c() {
        this.i = true;
        this.c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.f = 1.0E9d / this.c;
        this.b = e();
    }

    @Override // io.sentry.W
    public void d(C3148m1 c3148m1) throws NumberFormatException {
        if (this.i) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j = jElapsedRealtimeNanos - this.a;
            this.a = jElapsedRealtimeNanos;
            long jE = e();
            long j2 = jE - this.b;
            this.b = jE;
            c3148m1.e(Double.valueOf(((j2 / j) / this.d) * 100.0d));
        }
    }
}
