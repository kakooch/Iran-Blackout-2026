package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class C {
    private static WeakReference d;
    private final SharedPreferences a;
    private y b;
    private final Executor c;

    private C(SharedPreferences sharedPreferences, Executor executor) {
        this.c = executor;
        this.a = sharedPreferences;
    }

    public static synchronized C a(Context context, Executor executor) {
        C c;
        try {
            WeakReference weakReference = d;
            c = weakReference != null ? (C) weakReference.get() : null;
            if (c == null) {
                c = new C(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                c.c();
                d = new WeakReference(c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    private synchronized void c() {
        this.b = y.c(this.a, "topic_operation_queue", ",", this.c);
    }

    synchronized B b() {
        return B.a(this.b.e());
    }

    synchronized boolean d(B b) {
        return this.b.f(b.e());
    }
}
