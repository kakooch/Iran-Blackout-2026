package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.ILogger;
import io.sentry.Y2;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: io.sentry.android.core.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class FileObserverC3075s0 extends FileObserver {
    private final String a;
    private final io.sentry.Q b;
    private final ILogger c;
    private final long d;

    /* renamed from: io.sentry.android.core.s0$a */
    private static final class a implements io.sentry.hints.e, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i, io.sentry.hints.b, io.sentry.hints.j {
        boolean a;
        boolean b;
        private CountDownLatch c;
        private final long d;
        private final ILogger e;

        public a(long j, ILogger iLogger) {
            reset();
            this.d = j;
            this.e = (ILogger) io.sentry.util.u.c(iLogger, "ILogger is required.");
        }

        @Override // io.sentry.hints.k
        public boolean a() {
            return this.a;
        }

        @Override // io.sentry.hints.p
        public void c(boolean z) {
            this.b = z;
            this.c.countDown();
        }

        @Override // io.sentry.hints.k
        public void d(boolean z) {
            this.a = z;
        }

        @Override // io.sentry.hints.p
        public boolean e() {
            return this.b;
        }

        @Override // io.sentry.hints.i
        public boolean g() {
            try {
                return this.c.await(this.d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                this.e.b(Y2.ERROR, "Exception while awaiting on lock.", e);
                return false;
            }
        }

        @Override // io.sentry.hints.j
        public void reset() {
            this.c = new CountDownLatch(1);
            this.a = false;
            this.b = false;
        }
    }

    FileObserverC3075s0(String str, io.sentry.Q q, ILogger iLogger, long j) {
        super(str);
        this.a = str;
        this.b = (io.sentry.Q) io.sentry.util.u.c(q, "Envelope sender is required.");
        this.c = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required.");
        this.d = j;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (str == null || i != 8) {
            return;
        }
        this.c.c(Y2.DEBUG, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", Integer.valueOf(i), this.a, str);
        io.sentry.I iE = io.sentry.util.m.e(new a(this.d, this.c));
        this.b.a(this.a + File.separator + str, iE);
    }
}
