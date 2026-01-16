package androidx.datastore.preferences.protobuf;

import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class L implements V {
    private final I a;
    private final b0 b;
    private final boolean c;
    private final AbstractC1945n d;

    private L(b0 b0Var, AbstractC1945n abstractC1945n, I i) {
        this.b = b0Var;
        this.c = abstractC1945n.e(i);
        this.d = abstractC1945n;
        this.a = i;
    }

    private int j(b0 b0Var, Object obj) {
        return b0Var.i(b0Var.g(obj));
    }

    private void k(b0 b0Var, AbstractC1945n abstractC1945n, Object obj, U u, C1944m c1944m) {
        Object objF = b0Var.f(obj);
        C1948q c1948qD = abstractC1945n.d(obj);
        while (u.z() != Integer.MAX_VALUE) {
            try {
                if (!m(u, c1944m, abstractC1945n, c1948qD, b0Var, objF)) {
                    return;
                }
            } finally {
                b0Var.o(obj, objF);
            }
        }
    }

    static L l(b0 b0Var, AbstractC1945n abstractC1945n, I i) {
        return new L(b0Var, abstractC1945n, i);
    }

    private boolean m(U u, C1944m c1944m, AbstractC1945n abstractC1945n, C1948q c1948q, b0 b0Var, Object obj) throws InvalidProtocolBufferException {
        int tag = u.getTag();
        if (tag != g0.a) {
            if (g0.b(tag) != 2) {
                return u.C();
            }
            Object objB = abstractC1945n.b(c1944m, this.a, g0.a(tag));
            if (objB == null) {
                return b0Var.m(obj, u);
            }
            abstractC1945n.h(u, objB, c1944m, c1948q);
            return true;
        }
        Object objB2 = null;
        int iG = 0;
        AbstractC1937f abstractC1937fN = null;
        while (u.z() != Integer.MAX_VALUE) {
            int tag2 = u.getTag();
            if (tag2 == g0.c) {
                iG = u.g();
                objB2 = abstractC1945n.b(c1944m, this.a, iG);
            } else if (tag2 == g0.d) {
                if (objB2 != null) {
                    abstractC1945n.h(u, objB2, c1944m, c1948q);
                } else {
                    abstractC1937fN = u.n();
                }
            } else if (!u.C()) {
                break;
            }
        }
        if (u.getTag() != g0.b) {
            throw InvalidProtocolBufferException.a();
        }
        if (abstractC1937fN != null) {
            if (objB2 != null) {
                abstractC1945n.i(abstractC1937fN, objB2, c1944m, c1948q);
            } else {
                b0Var.d(obj, iG, abstractC1937fN);
            }
        }
        return true;
    }

    private void n(b0 b0Var, Object obj, h0 h0Var) {
        b0Var.s(b0Var.g(obj), h0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void a(Object obj, Object obj2) {
        X.F(this.b, obj, obj2);
        if (this.c) {
            X.D(this.d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public int b(Object obj) {
        int iHashCode = this.b.g(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.c(obj).hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public boolean c(Object obj, Object obj2) {
        if (!this.b.g(obj).equals(this.b.g(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(obj).equals(this.d.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public Object d() {
        return this.a.newBuilderForType().j();
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void e(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public final boolean f(Object obj) {
        return this.d.c(obj).k();
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public int g(Object obj) {
        int iJ = j(this.b, obj);
        return this.c ? iJ + this.d.c(obj).f() : iJ;
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void h(Object obj, U u, C1944m c1944m) {
        k(this.b, this.d, obj, u, c1944m);
    }

    @Override // androidx.datastore.preferences.protobuf.V
    public void i(Object obj, h0 h0Var) {
        Iterator itN = this.d.c(obj).n();
        if (itN.hasNext()) {
            AbstractC18350oW3.a(((Map.Entry) itN.next()).getKey());
            throw null;
        }
        n(this.b, obj, h0Var);
    }
}
