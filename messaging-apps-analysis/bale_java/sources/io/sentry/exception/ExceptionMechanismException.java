package io.sentry.exception;

import io.sentry.protocol.j;
import io.sentry.util.u;

/* loaded from: classes3.dex */
public final class ExceptionMechanismException extends RuntimeException {
    private final j a;
    private final Throwable b;
    private final Thread c;
    private final boolean d;

    public ExceptionMechanismException(j jVar, Throwable th, Thread thread, boolean z) {
        this.a = (j) u.c(jVar, "Mechanism is required.");
        this.b = (Throwable) u.c(th, "Throwable is required.");
        this.c = (Thread) u.c(thread, "Thread is required.");
        this.d = z;
    }

    public j a() {
        return this.a;
    }

    public Thread b() {
        return this.c;
    }

    public Throwable c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public ExceptionMechanismException(j jVar, Throwable th, Thread thread) {
        this(jVar, th, thread, false);
    }
}
