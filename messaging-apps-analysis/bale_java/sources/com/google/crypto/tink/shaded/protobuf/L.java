package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2343e;
import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class L implements V {
    private final I a;
    private final a0 b;
    private final boolean c;
    private final AbstractC2353o d;

    private L(a0 a0Var, AbstractC2353o abstractC2353o, I i) {
        this.b = a0Var;
        this.c = abstractC2353o.e(i);
        this.d = abstractC2353o;
        this.a = i;
    }

    private int k(a0 a0Var, Object obj) {
        return a0Var.i(a0Var.g(obj));
    }

    private void l(a0 a0Var, AbstractC2353o abstractC2353o, Object obj, U u, C2352n c2352n) {
        Object objF = a0Var.f(obj);
        r rVarD = abstractC2353o.d(obj);
        while (u.z() != Integer.MAX_VALUE) {
            try {
                if (!n(u, c2352n, abstractC2353o, rVarD, a0Var, objF)) {
                    return;
                }
            } finally {
                a0Var.o(obj, objF);
            }
        }
    }

    static L m(a0 a0Var, AbstractC2353o abstractC2353o, I i) {
        return new L(a0Var, abstractC2353o, i);
    }

    private boolean n(U u, C2352n c2352n, AbstractC2353o abstractC2353o, r rVar, a0 a0Var, Object obj) throws InvalidProtocolBufferException {
        int tag = u.getTag();
        if (tag != f0.a) {
            if (f0.b(tag) != 2) {
                return u.C();
            }
            Object objB = abstractC2353o.b(c2352n, this.a, f0.a(tag));
            if (objB == null) {
                return a0Var.m(obj, u);
            }
            abstractC2353o.h(u, objB, c2352n, rVar);
            return true;
        }
        Object objB2 = null;
        int iG = 0;
        AbstractC2345g abstractC2345gN = null;
        while (u.z() != Integer.MAX_VALUE) {
            int tag2 = u.getTag();
            if (tag2 == f0.c) {
                iG = u.g();
                objB2 = abstractC2353o.b(c2352n, this.a, iG);
            } else if (tag2 == f0.d) {
                if (objB2 != null) {
                    abstractC2353o.h(u, objB2, c2352n, rVar);
                } else {
                    abstractC2345gN = u.n();
                }
            } else if (!u.C()) {
                break;
            }
        }
        if (u.getTag() != f0.b) {
            throw InvalidProtocolBufferException.b();
        }
        if (abstractC2345gN != null) {
            if (objB2 != null) {
                abstractC2353o.i(abstractC2345gN, objB2, c2352n, rVar);
            } else {
                a0Var.d(obj, iG, abstractC2345gN);
            }
        }
        return true;
    }

    private void o(a0 a0Var, Object obj, g0 g0Var) {
        a0Var.s(a0Var.g(obj), g0Var);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void a(Object obj, Object obj2) {
        X.F(this.b, obj, obj2);
        if (this.c) {
            X.D(this.d, obj, obj2);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public int b(Object obj) {
        int iHashCode = this.b.g(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.c(obj).hashCode() : iHashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public boolean c(Object obj, Object obj2) {
        if (!this.b.g(obj).equals(this.b.g(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(obj).equals(this.d.c(obj2));
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public Object d() {
        I i = this.a;
        return i instanceof AbstractC2358u ? ((AbstractC2358u) i).G() : i.newBuilderForType().j();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void e(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public final boolean f(Object obj) {
        return this.d.c(obj).e();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public int g(Object obj) {
        int iK = k(this.b, obj);
        return this.c ? iK + this.d.c(obj).b() : iK;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void h(Object obj, byte[] bArr, int i, int i2, AbstractC2343e.a aVar) {
        AbstractC2358u abstractC2358u = (AbstractC2358u) obj;
        if (abstractC2358u.unknownFields == b0.c()) {
            abstractC2358u.unknownFields = b0.k();
        }
        AbstractC18350oW3.a(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void i(Object obj, U u, C2352n c2352n) {
        l(this.b, this.d, obj, u, c2352n);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.V
    public void j(Object obj, g0 g0Var) {
        Iterator itF = this.d.c(obj).f();
        if (itF.hasNext()) {
            AbstractC18350oW3.a(((Map.Entry) itF.next()).getKey());
            throw null;
        }
        o(this.b, obj, g0Var);
    }
}
