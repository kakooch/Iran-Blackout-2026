package com.google.protobuf;

/* loaded from: classes3.dex */
abstract class l0 {
    l0() {
    }

    abstract void a(Object obj, int i, int i2);

    abstract void b(Object obj, int i, long j);

    abstract void c(Object obj, int i, Object obj2);

    abstract void d(Object obj, int i, AbstractC2383g abstractC2383g);

    abstract void e(Object obj, int i, long j);

    abstract Object f(Object obj);

    abstract Object g(Object obj);

    abstract int h(Object obj);

    abstract int i(Object obj);

    abstract void j(Object obj);

    abstract Object k(Object obj, Object obj2);

    final void l(Object obj, d0 d0Var) {
        while (d0Var.z() != Integer.MAX_VALUE && m(obj, d0Var)) {
        }
    }

    final boolean m(Object obj, d0 d0Var) throws InvalidProtocolBufferException {
        int tag = d0Var.getTag();
        int iA = r0.a(tag);
        int iB = r0.b(tag);
        if (iB == 0) {
            e(obj, iA, d0Var.G());
            return true;
        }
        if (iB == 1) {
            b(obj, iA, d0Var.a());
            return true;
        }
        if (iB == 2) {
            d(obj, iA, d0Var.n());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            a(obj, iA, d0Var.t());
            return true;
        }
        Object objN = n();
        int iC = r0.c(iA, 4);
        l(objN, d0Var);
        if (iC != d0Var.getTag()) {
            throw InvalidProtocolBufferException.b();
        }
        c(obj, iA, r(objN));
        return true;
    }

    abstract Object n();

    abstract void o(Object obj, Object obj2);

    abstract void p(Object obj, Object obj2);

    abstract boolean q(d0 d0Var);

    abstract Object r(Object obj);

    abstract void s(Object obj, s0 s0Var);

    abstract void t(Object obj, s0 s0Var);
}
