package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* renamed from: io.appmetrica.analytics.impl.g4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2556g4 {
    public final C2532f4 a;
    public volatile C2871t9 b;
    public volatile C2871t9 c;

    public C2556g4() {
        this(new C2532f4());
    }

    public final IHandlerExecutor a() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-CDE");
                        this.b = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public final ICommonExecutor b() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.a.getClass();
                        Ua uaA = C2871t9.a("IAA-CRS");
                        this.c = new C2871t9(uaA, uaA.getLooper(), new Handler(uaA.getLooper()));
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public C2556g4(C2532f4 c2532f4) {
        this.a = c2532f4;
    }
}
