package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.B;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.InterfaceC3685Bx3;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2347i implements U {
    private final AbstractC2346h a;
    private int b;
    private int c;
    private int d = 0;

    private C2347i(AbstractC2346h abstractC2346h) {
        AbstractC2346h abstractC2346h2 = (AbstractC2346h) AbstractC2360w.b(abstractC2346h, "input");
        this.a = abstractC2346h2;
        abstractC2346h2.d = this;
    }

    public static C2347i N(AbstractC2346h abstractC2346h) {
        C2347i c2347i = abstractC2346h.d;
        return c2347i != null ? c2347i : new C2347i(abstractC2346h);
    }

    private void O(Object obj, V v, C2352n c2352n) {
        int i = this.c;
        this.c = f0.c(f0.a(this.b), 4);
        try {
            v.i(obj, this, c2352n);
            if (this.b == this.c) {
            } else {
                throw InvalidProtocolBufferException.j();
            }
        } finally {
            this.c = i;
        }
    }

    private void P(Object obj, V v, C2352n c2352n) throws InvalidProtocolBufferException {
        int iC = this.a.C();
        AbstractC2346h abstractC2346h = this.a;
        if (abstractC2346h.a >= abstractC2346h.b) {
            throw InvalidProtocolBufferException.k();
        }
        int iL = abstractC2346h.l(iC);
        this.a.a++;
        v.i(obj, this, c2352n);
        this.a.a(0);
        r5.a--;
        this.a.k(iL);
    }

    private Object Q(V v, C2352n c2352n) {
        Object objD = v.d();
        O(objD, v, c2352n);
        v.e(objD);
        return objD;
    }

    private Object R(V v, C2352n c2352n) throws InvalidProtocolBufferException {
        Object objD = v.d();
        P(objD, v, c2352n);
        v.e(objD);
        return objD;
    }

    private void T(int i) throws InvalidProtocolBufferException {
        if (this.a.d() != i) {
            throw InvalidProtocolBufferException.p();
        }
    }

    private void U(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (f0.b(this.b) != i) {
            throw InvalidProtocolBufferException.e();
        }
    }

    private void V(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.j();
        }
    }

    private void W(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.j();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void A(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(list, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void B(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2356s)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 2) {
                int iC = this.a.C();
                V(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Float.valueOf(this.a.s()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Float.valueOf(this.a.s()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        AbstractC2356s abstractC2356s = (AbstractC2356s) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            V(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                abstractC2356s.M(this.a.s());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            abstractC2356s.M(this.a.s());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.b);
        this.d = iB2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public boolean C() {
        int i;
        if (this.a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.E(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int D() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.v();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void E(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (f0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(n());
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.b);
        this.d = iB;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void F(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2349k)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 1) {
                do {
                    list.add(Double.valueOf(this.a.o()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iC = this.a.C();
            W(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Double.valueOf(this.a.o()));
            } while (this.a.d() < iD);
            return;
        }
        AbstractC2349k abstractC2349k = (AbstractC2349k) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 1) {
            do {
                abstractC2349k.s1(this.a.o());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iC2 = this.a.C();
        W(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            abstractC2349k.s1(this.a.o());
        } while (this.a.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public long G() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.u();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public String H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.A();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void I(Object obj, V v, C2352n c2352n) throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(3);
        O(obj, v, c2352n);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void J(Map map, B.a aVar, C2352n c2352n) throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        this.a.l(this.a.C());
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void K(Object obj, V v, C2352n c2352n) throws InvalidProtocolBufferException {
        U(2);
        P(obj, v, c2352n);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void L(List list, V v, C2352n c2352n) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (f0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int i = this.b;
        do {
            list.add(R(v, c2352n));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i);
        this.d = iB;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void M(List list, V v, C2352n c2352n) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (f0.b(this.b) != 3) {
            throw InvalidProtocolBufferException.e();
        }
        int i = this.b;
        do {
            list.add(Q(v, c2352n));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i);
        this.d = iB;
    }

    public void S(List list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        int iB2;
        if (f0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        if (!(list instanceof InterfaceC3685Bx3) || z) {
            do {
                list.add(z ? H() : y());
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        InterfaceC3685Bx3 interfaceC3685Bx3 = (InterfaceC3685Bx3) list;
        do {
            interfaceC3685Bx3.E1(n());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.b);
        this.d = iB2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.r();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void b(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 2) {
                int iC = this.a.C();
                V(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.a.v()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.a.v()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            V(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                abstractC2359v.b1(this.a.v());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            abstractC2359v.b1(this.a.v());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.b);
        this.d = iB2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void c(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2363z)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.y()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.y()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2363z abstractC2363z = (AbstractC2363z) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2363z.l1(this.a.y());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2363z.l1(this.a.y());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public boolean d() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public long e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.w();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void f(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2363z)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.D()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.D()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2363z abstractC2363z = (AbstractC2363z) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2363z.l1(this.a.D());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2363z.l1(this.a.D());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int g() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.C();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int getTag() {
        return this.b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void h(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2363z)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.u()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.u()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2363z abstractC2363z = (AbstractC2363z) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2363z.l1(this.a.u());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2363z.l1(this.a.u());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void i(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.p()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.p()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2359v.b1(this.a.p());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2359v.b1(this.a.p());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int j() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.x();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void l(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2344f)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.m()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Boolean.valueOf(this.a.m()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2344f abstractC2344f = (AbstractC2344f) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2344f.h(this.a.m());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2344f.h(this.a.m());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void m(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public AbstractC2345g n() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.n();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void p(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2363z)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.r()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iC = this.a.C();
            W(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Long.valueOf(this.a.r()));
            } while (this.a.d() < iD);
            return;
        }
        AbstractC2363z abstractC2363z = (AbstractC2363z) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 1) {
            do {
                abstractC2363z.l1(this.a.r());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iC2 = this.a.C();
        W(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            abstractC2363z.l1(this.a.r());
        } while (this.a.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void q(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.x()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.x()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2359v.b1(this.a.x());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2359v.b1(this.a.x());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public long r() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.D();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void s(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.C()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.C()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2359v.b1(this.a.C());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2359v.b1(this.a.C());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int t() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void u(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2363z)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.w()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iC = this.a.C();
            W(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Long.valueOf(this.a.w()));
            } while (this.a.d() < iD);
            return;
        }
        AbstractC2363z abstractC2363z = (AbstractC2363z) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 1) {
            do {
                abstractC2363z.l1(this.a.w());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iC2 = this.a.C();
        W(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            abstractC2363z.l1(this.a.w());
        } while (this.a.d() < iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void v(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.t()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.b);
                this.d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.t()));
            } while (this.a.d() < iD);
            T(iD);
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 0) {
            do {
                abstractC2359v.b1(this.a.t());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.b);
            this.d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            abstractC2359v.b1(this.a.t());
        } while (this.a.d() < iD2);
        T(iD2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public void w(List list) throws InvalidProtocolBufferException {
        int iB;
        int iB2;
        if (!(list instanceof AbstractC2359v)) {
            int iB3 = f0.b(this.b);
            if (iB3 == 2) {
                int iC = this.a.C();
                V(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.a.q()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.a.q()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        AbstractC2359v abstractC2359v = (AbstractC2359v) list;
        int iB4 = f0.b(this.b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            V(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                abstractC2359v.b1(this.a.q());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            abstractC2359v.b1(this.a.q());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.b);
        this.d = iB2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public long x() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.y();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public String y() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.z();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.U
    public int z() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.B();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return f0.a(i2);
    }
}
