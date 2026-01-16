package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.AbstractC14896if8;
import ir.nasim.AbstractC15486jf8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.InterfaceC13525gN5;

/* renamed from: com.google.android.gms.common.api.internal.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2063g {
    public final AbstractC2062f a;
    public final AbstractC2065i b;
    public final Runnable c;

    /* renamed from: com.google.android.gms.common.api.internal.g$a */
    public static class a {
        private InterfaceC13525gN5 a;
        private InterfaceC13525gN5 b;
        private C2060d d;
        private Feature[] e;
        private int g;
        private Runnable c = new Runnable() { // from class: ir.nasim.hf8
            @Override // java.lang.Runnable
            public final void run() {
            }
        };
        private boolean f = true;

        /* synthetic */ a(AbstractC14896if8 abstractC14896if8) {
        }

        public C2063g a() {
            AbstractC3795Cj5.b(this.a != null, "Must set register function");
            AbstractC3795Cj5.b(this.b != null, "Must set unregister function");
            AbstractC3795Cj5.b(this.d != null, "Must set holder");
            return new C2063g(new z(this, this.d, this.e, this.f, this.g), new A(this, (C2060d.a) AbstractC3795Cj5.k(this.d.b(), "Key must not be null")), this.c, null);
        }

        public a b(InterfaceC13525gN5 interfaceC13525gN5) {
            this.a = interfaceC13525gN5;
            return this;
        }

        public a c(int i) {
            this.g = i;
            return this;
        }

        public a d(InterfaceC13525gN5 interfaceC13525gN5) {
            this.b = interfaceC13525gN5;
            return this;
        }

        public a e(C2060d c2060d) {
            this.d = c2060d;
            return this;
        }
    }

    /* synthetic */ C2063g(AbstractC2062f abstractC2062f, AbstractC2065i abstractC2065i, Runnable runnable, AbstractC15486jf8 abstractC15486jf8) {
        this.a = abstractC2062f;
        this.b = abstractC2065i;
        this.c = runnable;
    }

    public static a a() {
        return new a(null);
    }
}
