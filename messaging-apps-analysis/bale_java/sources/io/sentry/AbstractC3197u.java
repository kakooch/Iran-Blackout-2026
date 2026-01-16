package io.sentry;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: io.sentry.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC3197u {
    private final Z a;
    private final ILogger b;
    private final long c;
    private final Queue d;

    /* renamed from: io.sentry.u$a */
    private static final class a implements io.sentry.hints.e, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i, io.sentry.hints.g {
        boolean a = false;
        boolean b = false;
        private final CountDownLatch c = new CountDownLatch(1);
        private final long d;
        private final ILogger e;
        private final String f;
        private final Queue g;

        public a(long j, ILogger iLogger, String str, Queue queue) {
            this.d = j;
            this.f = str;
            this.g = queue;
            this.e = iLogger;
        }

        @Override // io.sentry.hints.k
        public boolean a() {
            return this.a;
        }

        @Override // io.sentry.hints.g
        public void b() {
            this.g.add(this.f);
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
    }

    AbstractC3197u(Z z, ILogger iLogger, long j, int i) {
        this.a = z;
        this.b = iLogger;
        this.c = j;
        this.d = R3.r(new C3111f(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(File file, String str) {
        return c(str);
    }

    protected abstract boolean c(String str);

    public void e(File file) {
        try {
            ILogger iLogger = this.b;
            Y2 y2 = Y2.DEBUG;
            iLogger.c(y2, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.b.c(Y2.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
                return;
            }
            if (!file.isDirectory()) {
                this.b.c(Y2.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                this.b.c(Y2.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: io.sentry.t
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    return this.a.d(file2, str);
                }
            });
            this.b.c(y2, "Processing %d items from cache dir %s", Integer.valueOf(fileArrListFiles2 != null ? fileArrListFiles2.length : 0), file.getAbsolutePath());
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    String absolutePath = file2.getAbsolutePath();
                    if (this.d.contains(absolutePath)) {
                        this.b.c(Y2.DEBUG, "File '%s' has already been processed so it will not be processed again.", absolutePath);
                    } else {
                        io.sentry.transport.A aW = this.a.w();
                        if (aW != null && aW.l(EnumC3136k.All)) {
                            this.b.c(Y2.INFO, "DirectoryProcessor, rate limiting active.", new Object[0]);
                            return;
                        } else {
                            this.b.c(Y2.DEBUG, "Processing file: %s", absolutePath);
                            f(file2, io.sentry.util.m.e(new a(this.c, this.b, absolutePath, this.d)));
                            Thread.sleep(100L);
                        }
                    }
                } else {
                    this.b.c(Y2.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            this.b.a(Y2.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    protected abstract void f(File file, I i);
}
