package ir.nasim;

import ir.nasim.C10647bx5;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.fx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13280fx5 extends h.d implements V64 {
    private static final C13280fx5 m;
    public static LW4 n = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private int d;
    private int e;
    private int f;
    private C10647bx5 g;
    private int h;
    private C10647bx5 i;
    private int j;
    private byte k;
    private int l;

    /* renamed from: ir.nasim.fx5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C13280fx5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C13280fx5(eVar, fVar);
        }
    }

    static {
        C13280fx5 c13280fx5 = new C13280fx5(true);
        m = c13280fx5;
        c13280fx5.a0();
    }

    public static C13280fx5 M() {
        return m;
    }

    private void a0() {
        this.e = 0;
        this.f = 0;
        this.g = C10647bx5.b0();
        this.h = 0;
        this.i = C10647bx5.b0();
        this.j = 0;
    }

    public static b b0() {
        return b.q();
    }

    public static b c0(C13280fx5 c13280fx5) {
        return b0().e(c13280fx5);
    }

    @Override // ir.nasim.V64
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public C13280fx5 getDefaultInstanceForType() {
        return m;
    }

    public int O() {
        return this.e;
    }

    public int P() {
        return this.f;
    }

    public C10647bx5 Q() {
        return this.g;
    }

    public int R() {
        return this.h;
    }

    public C10647bx5 S() {
        return this.i;
    }

    public int T() {
        return this.j;
    }

    public boolean U() {
        return (this.d & 1) == 1;
    }

    public boolean V() {
        return (this.d & 2) == 2;
    }

    public boolean W() {
        return (this.d & 4) == 4;
    }

    public boolean X() {
        return (this.d & 8) == 8;
    }

    public boolean Y() {
        return (this.d & 16) == 16;
    }

    public boolean Z() {
        return (this.d & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        h.d.a aVarZ = z();
        if ((this.d & 1) == 1) {
            codedOutputStream.Z(1, this.e);
        }
        if ((this.d & 2) == 2) {
            codedOutputStream.Z(2, this.f);
        }
        if ((this.d & 4) == 4) {
            codedOutputStream.c0(3, this.g);
        }
        if ((this.d & 16) == 16) {
            codedOutputStream.c0(4, this.i);
        }
        if ((this.d & 8) == 8) {
            codedOutputStream.Z(5, this.h);
        }
        if ((this.d & 32) == 32) {
            codedOutputStream.Z(6, this.j);
        }
        aVarZ.a(200, codedOutputStream);
        codedOutputStream.h0(this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return b0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return c0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.l;
        if (i != -1) {
            return i;
        }
        int iO = (this.d & 1) == 1 ? CodedOutputStream.o(1, this.e) : 0;
        if ((this.d & 2) == 2) {
            iO += CodedOutputStream.o(2, this.f);
        }
        if ((this.d & 4) == 4) {
            iO += CodedOutputStream.r(3, this.g);
        }
        if ((this.d & 16) == 16) {
            iO += CodedOutputStream.r(4, this.i);
        }
        if ((this.d & 8) == 8) {
            iO += CodedOutputStream.o(5, this.h);
        }
        if ((this.d & 32) == 32) {
            iO += CodedOutputStream.o(6, this.j);
        }
        int iR = iO + r() + this.c.size();
        this.l = iR;
        return iR;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!V()) {
            this.k = (byte) 0;
            return false;
        }
        if (W() && !Q().isInitialized()) {
            this.k = (byte) 0;
            return false;
        }
        if (Y() && !S().isInitialized()) {
            this.k = (byte) 0;
            return false;
        }
        if (q()) {
            this.k = (byte) 1;
            return true;
        }
        this.k = (byte) 0;
        return false;
    }

    private C13280fx5(h.c cVar) {
        super(cVar);
        this.k = (byte) -1;
        this.l = -1;
        this.c = cVar.d();
    }

    private C13280fx5(boolean z) {
        this.k = (byte) -1;
        this.l = -1;
        this.c = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C13280fx5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        C10647bx5.c builder;
        this.k = (byte) -1;
        this.l = -1;
        a0();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.d |= 1;
                            this.e = eVar.r();
                        } else if (iJ != 16) {
                            if (iJ == 26) {
                                builder = (this.d & 4) == 4 ? this.g.toBuilder() : null;
                                C10647bx5 c10647bx5 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.g = c10647bx5;
                                if (builder != null) {
                                    builder.e(c10647bx5);
                                    this.g = builder.o();
                                }
                                this.d |= 4;
                            } else if (iJ == 34) {
                                builder = (this.d & 16) == 16 ? this.i.toBuilder() : null;
                                C10647bx5 c10647bx52 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                                this.i = c10647bx52;
                                if (builder != null) {
                                    builder.e(c10647bx52);
                                    this.i = builder.o();
                                }
                                this.d |= 16;
                            } else if (iJ == 40) {
                                this.d |= 8;
                                this.h = eVar.r();
                            } else if (iJ != 48) {
                                if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                                }
                            } else {
                                this.d |= 32;
                                this.j = eVar.r();
                            }
                        } else {
                            this.d |= 2;
                            this.f = eVar.r();
                        }
                    }
                    z = true;
                } catch (Throwable th) {
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

    /* renamed from: ir.nasim.fx5$b */
    public static final class b extends h.c implements V64 {
        private int d;
        private int e;
        private int f;
        private int h;
        private int j;
        private C10647bx5 g = C10647bx5.b0();
        private C10647bx5 i = C10647bx5.b0();

        private b() {
            r();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b q() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public C13280fx5 a() {
            C13280fx5 c13280fx5O = o();
            if (c13280fx5O.isInitialized()) {
                return c13280fx5O;
            }
            throw a.AbstractC1828a.c(c13280fx5O);
        }

        public C13280fx5 o() {
            C13280fx5 c13280fx5 = new C13280fx5(this);
            int i = this.d;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c13280fx5.e = this.e;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c13280fx5.f = this.f;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c13280fx5.g = this.g;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c13280fx5.h = this.h;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c13280fx5.i = this.i;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            c13280fx5.j = this.j;
            c13280fx5.d = i2;
            return c13280fx5;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return q().e(o());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b e(C13280fx5 c13280fx5) {
            if (c13280fx5 == C13280fx5.M()) {
                return this;
            }
            if (c13280fx5.U()) {
                w(c13280fx5.O());
            }
            if (c13280fx5.V()) {
                x(c13280fx5.P());
            }
            if (c13280fx5.W()) {
                u(c13280fx5.Q());
            }
            if (c13280fx5.X()) {
                y(c13280fx5.R());
            }
            if (c13280fx5.Y()) {
                v(c13280fx5.S());
            }
            if (c13280fx5.Z()) {
                z(c13280fx5.T());
            }
            l(c13280fx5);
            f(d().h(c13280fx5.c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C13280fx5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C13280fx5.n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.fx5 r3 = (ir.nasim.C13280fx5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.fx5 r4 = (ir.nasim.C13280fx5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13280fx5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.fx5$b");
        }

        public b u(C10647bx5 c10647bx5) {
            if ((this.d & 4) != 4 || this.g == C10647bx5.b0()) {
                this.g = c10647bx5;
            } else {
                this.g = C10647bx5.D0(this.g).e(c10647bx5).o();
            }
            this.d |= 4;
            return this;
        }

        public b v(C10647bx5 c10647bx5) {
            if ((this.d & 16) != 16 || this.i == C10647bx5.b0()) {
                this.i = c10647bx5;
            } else {
                this.i = C10647bx5.D0(this.i).e(c10647bx5).o();
            }
            this.d |= 16;
            return this;
        }

        public b w(int i) {
            this.d |= 1;
            this.e = i;
            return this;
        }

        public b x(int i) {
            this.d |= 2;
            this.f = i;
            return this;
        }

        public b y(int i) {
            this.d |= 8;
            this.h = i;
            return this;
        }

        public b z(int i) {
            this.d |= 32;
            this.j = i;
            return this;
        }

        private void r() {
        }
    }
}
