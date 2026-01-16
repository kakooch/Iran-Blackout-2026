package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import ir.nasim.AbstractC13042fc3;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class J7 {
    public final Context a;
    public final ProtobufStateStorage b;
    public final L7 c;
    public final Xm d;
    public final Jl e;
    public final InterfaceC2617ii f;
    public final InterfaceC2570gi g;
    public final InterfaceC2940w6 h;
    public K7 i;

    public J7(Context context, ProtobufStateStorage protobufStateStorage, L7 l7, Xm xm, Jl jl, InterfaceC2617ii interfaceC2617ii, InterfaceC2570gi interfaceC2570gi, InterfaceC2940w6 interfaceC2940w6, K7 k7) {
        this.a = context;
        this.b = protobufStateStorage;
        this.c = l7;
        this.d = xm;
        this.e = jl;
        this.f = interfaceC2617ii;
        this.g = interfaceC2570gi;
        this.h = interfaceC2940w6;
        this.i = k7;
    }

    public final synchronized K7 a() {
        return this.i;
    }

    public final synchronized boolean b(N7 n7) {
        try {
            boolean z = false;
            if (n7.a() == M7.b) {
                return false;
            }
            if (AbstractC13042fc3.d(n7, this.i.b())) {
                return false;
            }
            List listA = (List) this.d.invoke(this.i.a(), n7);
            boolean z2 = listA != null;
            if (listA == null) {
                listA = this.i.a();
            }
            if (this.c.a(n7, this.i.b())) {
                z = true;
            } else {
                n7 = (N7) this.i.b();
            }
            if (z || z2) {
                K7 k7 = this.i;
                K7 k72 = (K7) this.e.invoke(n7, listA);
                this.i = k72;
                this.b.save(k72);
                AbstractC2904ui.a("Update distribution data: %s -> %s", k7, this.i);
            }
            return z;
        } finally {
        }
    }

    public final synchronized N7 c() {
        try {
            if (!this.g.a()) {
                N7 n7 = (N7) this.f.invoke();
                this.g.b();
                if (n7 != null) {
                    b(n7);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (N7) this.i.b();
    }

    public final N7 a(N7 n7) {
        N7 n7C;
        this.h.a(this.a);
        synchronized (this) {
            b(n7);
            n7C = c();
        }
        return n7C;
    }

    public final N7 b() {
        this.h.a(this.a);
        return c();
    }
}
