package com.bumptech.glide;

import ir.nasim.AbstractC3322Aj5;
import ir.nasim.InterfaceC3905Cv7;
import ir.nasim.SA4;
import ir.nasim.YM7;

/* loaded from: classes2.dex */
public abstract class i implements Cloneable {
    private InterfaceC3905Cv7 a = SA4.c();

    private i d() {
        return this;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    final InterfaceC3905Cv7 c() {
        return this.a;
    }

    public final i e(InterfaceC3905Cv7 interfaceC3905Cv7) {
        this.a = (InterfaceC3905Cv7) AbstractC3322Aj5.d(interfaceC3905Cv7);
        return d();
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return YM7.e(this.a, ((i) obj).a);
        }
        return false;
    }

    public int hashCode() {
        InterfaceC3905Cv7 interfaceC3905Cv7 = this.a;
        if (interfaceC3905Cv7 != null) {
            return interfaceC3905Cv7.hashCode();
        }
        return 0;
    }
}
