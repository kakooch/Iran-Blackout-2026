package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import ir.nasim.AbstractC18441of8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C4982Hj7;
import ir.nasim.InterfaceC13525gN5;

/* renamed from: com.google.android.gms.common.api.internal.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2064h {
    private final Feature[] a;
    private final boolean b;
    private final int c;

    /* renamed from: com.google.android.gms.common.api.internal.h$a */
    public static class a {
        private InterfaceC13525gN5 a;
        private Feature[] c;
        private boolean b = true;
        private int d = 0;

        /* synthetic */ a(AbstractC18441of8 abstractC18441of8) {
        }

        public AbstractC2064h a() {
            AbstractC3795Cj5.b(this.a != null, "execute parameter required");
            return new B(this, this.c, this.b, this.d);
        }

        public a b(InterfaceC13525gN5 interfaceC13525gN5) {
            this.a = interfaceC13525gN5;
            return this;
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }

        public a d(Feature... featureArr) {
            this.c = featureArr;
            return this;
        }

        public a e(int i) {
            this.d = i;
            return this;
        }
    }

    protected AbstractC2064h(Feature[] featureArr, boolean z, int i) {
        this.a = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.b = z2;
        this.c = i;
    }

    public static a a() {
        return new a(null);
    }

    protected abstract void b(a.b bVar, C4982Hj7 c4982Hj7);

    public boolean c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final Feature[] e() {
        return this.a;
    }
}
