package io.sentry.android.core;

/* loaded from: classes3.dex */
final class ApplicationNotResponding extends RuntimeException {
    private final Thread a;

    ApplicationNotResponding(String str, Thread thread) {
        super(str);
        Thread thread2 = (Thread) io.sentry.util.u.c(thread, "Thread must be provided.");
        this.a = thread2;
        setStackTrace(thread2.getStackTrace());
    }

    public Thread a() {
        return this.a;
    }
}
