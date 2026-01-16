package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: io.appmetrica.analytics.impl.q9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2800q9 {
    public final ReentrantLock a;
    public final S9 b;

    public C2800q9(Context context, String str) {
        this(new ReentrantLock(), new S9(context, str));
    }

    public final void a() {
        this.a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.a.unlock();
    }

    public final void c() {
        S9 s9 = this.b;
        synchronized (s9) {
            s9.b();
            s9.a.delete();
        }
        this.a.unlock();
    }

    public C2800q9(ReentrantLock reentrantLock, S9 s9) {
        this.a = reentrantLock;
        this.b = s9;
    }
}
