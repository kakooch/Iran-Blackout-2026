package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* renamed from: io.appmetrica.analytics.impl.tj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2881tj {
    public final C2857sj a;
    public volatile C2871t9 b;
    public volatile C2871t9 c;
    public volatile C2871t9 d;
    public volatile C2871t9 e;
    public volatile C2871t9 f;
    public volatile C2871t9 g;
    public volatile ExecutorC2833rj h;

    public C2881tj() {
        this(new C2857sj());
    }

    public final IHandlerExecutor a() {
        if (this.g == null) {
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-SDE");
                        this.g = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    public final IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-SC");
                        this.b = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public final IHandlerExecutor c() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-SMH-1");
                        this.d = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public final IHandlerExecutor d() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-SNTPE");
                        this.e = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public final IHandlerExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-STE");
                        this.c = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public final Executor f() {
        if (this.h == null) {
            synchronized (this) {
                try {
                    if (this.h == null) {
                        this.a.getClass();
                        this.h = new ExecutorC2833rj(new Handler(Looper.getMainLooper()));
                    }
                } finally {
                }
            }
        }
        return this.h;
    }

    public C2881tj(C2857sj c2857sj) {
        new HashMap();
        this.a = c2857sj;
    }
}
