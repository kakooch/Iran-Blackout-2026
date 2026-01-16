package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
abstract class a0 {
    a0() {
    }

    abstract void a(Object obj, int i, int i2);

    abstract void b(Object obj, int i, long j);

    abstract void c(Object obj, int i, Object obj2);

    abstract void d(Object obj, int i, AbstractC2345g abstractC2345g);

    abstract void e(Object obj, int i, long j);

    abstract Object f(Object obj);

    abstract Object g(Object obj);

    abstract int h(Object obj);

    abstract int i(Object obj);

    abstract void j(Object obj);

    abstract Object k(Object obj, Object obj2);

    final void l(Object obj, U u) {
        while (u.z() != Integer.MAX_VALUE && m(obj, u)) {
        }
    }

    final boolean m(Object obj, U u) throws InvalidProtocolBufferException {
        int tag = u.getTag();
        int iA = f0.a(tag);
        int iB = f0.b(tag);
        if (iB == 0) {
            e(obj, iA, u.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, u.a());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, u.n());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            a(obj, iA, u.t());
            return true;
        }
        Object objN = n();
        int iC = f0.c(iA, 4);
        l(objN, u);
        if (iC != u.getTag()) {
            throw InvalidProtocolBufferException.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    abstract Object n();

    abstract void o(Object obj, Object obj2);

    abstract void p(Object obj, Object obj2);

    abstract boolean q(U u);

    abstract Object r(Object obj);

    abstract void s(Object obj, g0 g0Var);

    abstract void t(Object obj, g0 g0Var);
}
