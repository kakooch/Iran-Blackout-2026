package io.sentry.transport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: classes3.dex */
public final class B {
    private final a a;

    private static final class a extends AbstractQueuedSynchronizer {
        a(int i) {
            setState(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            releaseShared(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e() {
            return getState();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            int state;
            do {
                state = getState();
            } while (!compareAndSetState(state, state + 1));
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public int tryAcquireShared(int i) {
            return getState() == 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryReleaseShared(int i) {
            int state;
            int i2;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i2 = state - 1;
            } while (!compareAndSetState(state, i2));
            return i2 == 0;
        }
    }

    public B(int i) {
        if (i >= 0) {
            this.a = new a(i);
            return;
        }
        throw new IllegalArgumentException("negative initial count '" + i + "' is not allowed");
    }

    public void a() {
        this.a.d();
    }

    public int b() {
        return this.a.e();
    }

    public void c() {
        this.a.f();
    }

    public boolean d(long j, TimeUnit timeUnit) {
        return this.a.tryAcquireSharedNanos(1, timeUnit.toNanos(j));
    }

    public B() {
        this(0);
    }
}
