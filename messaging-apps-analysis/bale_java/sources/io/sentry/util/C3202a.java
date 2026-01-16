package io.sentry.util;

import io.sentry.InterfaceC3102d0;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: io.sentry.util.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3202a extends ReentrantLock {

    /* renamed from: io.sentry.util.a$a, reason: collision with other inner class name */
    static final class C0252a implements InterfaceC3102d0 {
        private final ReentrantLock a;

        C0252a(ReentrantLock reentrantLock) {
            this.a = reentrantLock;
        }

        @Override // io.sentry.InterfaceC3102d0, java.lang.AutoCloseable
        public void close() {
            this.a.unlock();
        }
    }

    public InterfaceC3102d0 a() {
        lock();
        return new C0252a(this);
    }
}
