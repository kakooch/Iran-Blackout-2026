package io.appmetrica.analytics.impl;

import android.util.Pair;

/* renamed from: io.appmetrica.analytics.impl.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2429b0 {
    public C2755oc a;
    public long b;
    public boolean c;
    public final C2811qk d;

    public C2429b0(String str, long j, C2811qk c2811qk) {
        this.b = j;
        try {
            this.a = new C2755oc(str);
        } catch (Throwable unused) {
            this.a = new C2755oc();
        }
        this.d = c2811qk;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C2404a0 a() {
        try {
            if (this.c) {
                this.b++;
                this.c = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new C2404a0(Ya.b(this.a), this.b);
    }
}
