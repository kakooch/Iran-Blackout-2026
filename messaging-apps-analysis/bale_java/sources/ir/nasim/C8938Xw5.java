package ir.nasim;

import ir.nasim.C10030ax5;
import ir.nasim.C8652Ww5;
import ir.nasim.C9427Zw5;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Xw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8938Xw5 extends h.d implements V64 {
    private static final C8938Xw5 k;
    public static LW4 l = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private C10030ax5 e;
    private C9427Zw5 f;
    private C8652Ww5 g;
    private List h;
    private byte i;
    private int j;

    /* renamed from: ir.nasim.Xw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C8938Xw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C8938Xw5(eVar, fVar);
        }
    }

    static {
        C8938Xw5 c8938Xw5 = new C8938Xw5(true);
        k = c8938Xw5;
        c8938Xw5.W();
    }

    public static C8938Xw5 O() {
        return k;
    }

    private void W() {
        this.e = C10030ax5.s();
        this.f = C9427Zw5.s();
        this.g = C8652Ww5.O();
        this.h = Collections.emptyList();
    }

    public static b X() {
        return b.q();
    }

    public static b Y(C8938Xw5 c8938Xw5) {
        return X().e(c8938Xw5);
    }

    public static C8938Xw5 a0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        return (C8938Xw5) l.a(inputStream, fVar);
    }

    public C6526Nw5 L(int i) {
        return (C6526Nw5) this.h.get(i);
    }

    public int M() {
        return this.h.size();
    }

    public List N() {
        return this.h;
    }

    @Override // ir.nasim.V64
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C8938Xw5 getDefaultInstanceForType() {
        return k;
    }

    public C8652Ww5 Q() {
        return this.g;
    }

    public C9427Zw5 R() {
        return this.f;
    }

    public C10030ax5 S() {
        return this.e;
    }

    public boolean T() {
        return (this.d & 4) == 4;
    }

    public boolean U() {
        return (this.d & 2) == 2;
    }

    public boolean V() {
        return (this.d & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.c0(1, this.e);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.c0(2, this.f);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.c0(3, this.g);
        }
        for (int i = 0; i < this.h.size(); i++) {
            codedOutputStream.c0(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.h.get(i));
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return Y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.j;
        if (i != -1) {
            return i;
        }
        int iR = (this.d & 1) == 1 ? CodedOutputStream.r(1, this.e) : 0;
        if ((this.d & 2) == 2) {
            iR += CodedOutputStream.r(2, this.f);
        }
        if ((this.d & 4) == 4) {
            iR += CodedOutputStream.r(3, this.g);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            iR += CodedOutputStream.r(4, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.h.get(i2));
        }
        int iR2 = iR + r() + this.c.size();
        this.j = iR2;
        return iR2;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.i;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (U() && !R().isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        if (T() && !Q().isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        for (int i = 0; i < M(); i++) {
            if (!L(i).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        if (q()) {
            this.i = (byte) 1;
            return true;
        }
        this.i = (byte) 0;
        return false;
    }

    private C8938Xw5(h.c cVar) {
        super(cVar);
        this.i = (byte) -1;
        this.j = -1;
        this.c = cVar.d();
    }

    private C8938Xw5(boolean z) {
        this.i = (byte) -1;
        this.j = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C8938Xw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.i = (byte) -1;
        this.j = -1;
        W();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        char c = 0;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 10) {
                            C10030ax5.b builder = (this.d & 1) == 1 ? this.e.toBuilder() : null;
                            C10030ax5 c10030ax5 = (C10030ax5) eVar.t(C10030ax5.g, fVar);
                            this.e = c10030ax5;
                            if (builder != null) {
                                builder.e(c10030ax5);
                                this.e = builder.k();
                            }
                            this.d |= 1;
                        } else if (iJ == 18) {
                            C9427Zw5.b builder2 = (this.d & 2) == 2 ? this.f.toBuilder() : null;
                            C9427Zw5 c9427Zw5 = (C9427Zw5) eVar.t(C9427Zw5.g, fVar);
                            this.f = c9427Zw5;
                            if (builder2 != null) {
                                builder2.e(c9427Zw5);
                                this.f = builder2.k();
                            }
                            this.d |= 2;
                        } else if (iJ == 26) {
                            C8652Ww5.b builder3 = (this.d & 4) == 4 ? this.g.toBuilder() : null;
                            C8652Ww5 c8652Ww5 = (C8652Ww5) eVar.t(C8652Ww5.m, fVar);
                            this.g = c8652Ww5;
                            if (builder3 != null) {
                                builder3.e(c8652Ww5);
                                this.g = builder3.o();
                            }
                            this.d |= 4;
                        } else if (iJ != 34) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            int i = (c == true ? 1 : 0) & '\b';
                            c = c;
                            if (i != 8) {
                                this.h = new ArrayList();
                                c = '\b';
                            }
                            this.h.add(eVar.t(C6526Nw5.A, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & '\b') == 8) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    try {
                        codedOutputStreamI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.c = bVarB.e();
                        throw th2;
                    }
                    this.c = bVarB.e();
                    j();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.k(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).k(this);
            }
        }
        if (((c == true ? 1 : 0) & '\b') == 8) {
            this.h = Collections.unmodifiableList(this.h);
        }
        try {
            codedOutputStreamI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.c = bVarB.e();
            throw th3;
        }
        this.c = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.Xw5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private C10030ax5 e = C10030ax5.s();
        private C9427Zw5 f = C9427Zw5.s();
        private C8652Ww5 g = C8652Ww5.O();
        private List h = Collections.emptyList();

        private b() {
            s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        private void r() {
            if ((this.d & 8) != 8) {
                this.h = new ArrayList(this.h);
                this.d |= 8;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C8938Xw5 a() {
            C8938Xw5 c8938Xw5O = o();
            if (c8938Xw5O.isInitialized()) {
                return c8938Xw5O;
            }
            throw a.AbstractC1828a.c(c8938Xw5O);
        }

        public C8938Xw5 o() {
            C8938Xw5 c8938Xw5 = new C8938Xw5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c8938Xw5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c8938Xw5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c8938Xw5.g = this.g;
            if ((this.d & 8) == 8) {
                this.h = Collections.unmodifiableList(this.h);
                this.d &= -9;
            }
            c8938Xw5.h = this.h;
            c8938Xw5.d = i2;
            return c8938Xw5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b e(C8938Xw5 c8938Xw5) {
            if (c8938Xw5 == C8938Xw5.O()) {
                return this;
            }
            if (c8938Xw5.V()) {
                x(c8938Xw5.S());
            }
            if (c8938Xw5.U()) {
                w(c8938Xw5.R());
            }
            if (c8938Xw5.T()) {
                v(c8938Xw5.Q());
            }
            if (!c8938Xw5.h.isEmpty()) {
                if (this.h.isEmpty()) {
                    this.h = c8938Xw5.h;
                    this.d &= -9;
                } else {
                    r();
                    this.h.addAll(c8938Xw5.h);
                }
            }
            l(c8938Xw5);
            f(d().h(c8938Xw5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C8938Xw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C8938Xw5.l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Xw5 r3 = (ir.nasim.C8938Xw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.e(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.l r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ir.nasim.Xw5 r4 = (ir.nasim.C8938Xw5) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.e(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8938Xw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Xw5$b");
        }

        public b v(C8652Ww5 c8652Ww5) {
            if ((this.d & 4) != 4 || this.g == C8652Ww5.O()) {
                this.g = c8652Ww5;
            } else {
                this.g = C8652Ww5.g0(this.g).e(c8652Ww5).o();
            }
            this.d |= 4;
            return this;
        }

        public b w(C9427Zw5 c9427Zw5) {
            if ((this.d & 2) != 2 || this.f == C9427Zw5.s()) {
                this.f = c9427Zw5;
            } else {
                this.f = C9427Zw5.C(this.f).e(c9427Zw5).k();
            }
            this.d |= 2;
            return this;
        }

        public b x(C10030ax5 c10030ax5) {
            if ((this.d & 1) != 1 || this.e == C10030ax5.s()) {
                this.e = c10030ax5;
            } else {
                this.e = C10030ax5.C(this.e).e(c10030ax5).k();
            }
            this.d |= 1;
            return this;
        }

        private void s() {
        }
    }
}
