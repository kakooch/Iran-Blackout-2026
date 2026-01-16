package ir.nasim;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.gx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13871gx5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C13871gx5 l;
    public static LW4 m = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private int c;
    private int d;
    private int e;
    private c f;
    private int g;
    private int h;
    private d i;
    private byte j;
    private int k;

    /* renamed from: ir.nasim.gx5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C13871gx5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C13871gx5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.gx5$c */
    public enum c implements i.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.gx5$c$a */
        static class a implements i.b {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i) {
                return c.a(i);
            }
        }

        c(int i, int i2) {
            this.a = i2;
        }

        public static c a(int i) {
            if (i == 0) {
                return WARNING;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.gx5$d */
    public enum d implements i.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.gx5$d$a */
        static class a implements i.b {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i) {
                return d.a(i);
            }
        }

        d(int i, int i2) {
            this.a = i2;
        }

        public static d a(int i) {
            if (i == 0) {
                return LANGUAGE_VERSION;
            }
            if (i == 1) {
                return COMPILER_VERSION;
            }
            if (i != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        C13871gx5 c13871gx5 = new C13871gx5(true);
        l = c13871gx5;
        c13871gx5.Q();
    }

    public static C13871gx5 C() {
        return l;
    }

    private void Q() {
        this.d = 0;
        this.e = 0;
        this.f = c.ERROR;
        this.g = 0;
        this.h = 0;
        this.i = d.LANGUAGE_VERSION;
    }

    public static b R() {
        return b.m();
    }

    public static b S(C13871gx5 c13871gx5) {
        return R().e(c13871gx5);
    }

    public int D() {
        return this.g;
    }

    public c E() {
        return this.f;
    }

    public int F() {
        return this.h;
    }

    public int G() {
        return this.d;
    }

    public int H() {
        return this.e;
    }

    public d J() {
        return this.i;
    }

    public boolean K() {
        return (this.c & 8) == 8;
    }

    public boolean L() {
        return (this.c & 4) == 4;
    }

    public boolean M() {
        return (this.c & 16) == 16;
    }

    public boolean N() {
        return (this.c & 1) == 1;
    }

    public boolean O() {
        return (this.c & 2) == 2;
    }

    public boolean P() {
        return (this.c & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return S(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void b(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.c & 1) == 1) {
            codedOutputStream.Z(1, this.d);
        }
        if ((this.c & 2) == 2) {
            codedOutputStream.Z(2, this.e);
        }
        if ((this.c & 4) == 4) {
            codedOutputStream.R(3, this.f.getNumber());
        }
        if ((this.c & 8) == 8) {
            codedOutputStream.Z(4, this.g);
        }
        if ((this.c & 16) == 16) {
            codedOutputStream.Z(5, this.h);
        }
        if ((this.c & 32) == 32) {
            codedOutputStream.R(6, this.i.getNumber());
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.k;
        if (i != -1) {
            return i;
        }
        int iO = (this.c & 1) == 1 ? CodedOutputStream.o(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iO += CodedOutputStream.o(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iO += CodedOutputStream.h(3, this.f.getNumber());
        }
        if ((this.c & 8) == 8) {
            iO += CodedOutputStream.o(4, this.g);
        }
        if ((this.c & 16) == 16) {
            iO += CodedOutputStream.o(5, this.h);
        }
        if ((this.c & 32) == 32) {
            iO += CodedOutputStream.h(6, this.i.getNumber());
        }
        int size = iO + this.b.size();
        this.k = size;
        return size;
    }

    @Override // ir.nasim.V64
    public final boolean isInitialized() {
        byte b2 = this.j;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.j = (byte) 1;
        return true;
    }

    private C13871gx5(h.b bVar) {
        super(bVar);
        this.j = (byte) -1;
        this.k = -1;
        this.b = bVar.d();
    }

    private C13871gx5(boolean z) {
        this.j = (byte) -1;
        this.k = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C13871gx5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.j = (byte) -1;
        this.k = -1;
        Q();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.c |= 1;
                            this.d = eVar.r();
                        } else if (iJ == 16) {
                            this.c |= 2;
                            this.e = eVar.r();
                        } else if (iJ == 24) {
                            int iM = eVar.m();
                            c cVarA = c.a(iM);
                            if (cVarA == null) {
                                codedOutputStreamI.n0(iJ);
                                codedOutputStreamI.n0(iM);
                            } else {
                                this.c |= 4;
                                this.f = cVarA;
                            }
                        } else if (iJ == 32) {
                            this.c |= 8;
                            this.g = eVar.r();
                        } else if (iJ == 40) {
                            this.c |= 16;
                            this.h = eVar.r();
                        } else if (iJ != 48) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            int iM2 = eVar.m();
                            d dVarA = d.a(iM2);
                            if (dVarA == null) {
                                codedOutputStreamI.n0(iJ);
                                codedOutputStreamI.n0(iM2);
                            } else {
                                this.c |= 32;
                                this.i = dVarA;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    try {
                        codedOutputStreamI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = bVarB.e();
                        throw th2;
                    }
                    this.b = bVarB.e();
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
            this.b = bVarB.e();
            throw th3;
        }
        this.b = bVarB.e();
        j();
    }

    /* renamed from: ir.nasim.gx5$b */
    public static final class b extends h.b implements V64 {
        private int b;
        private int c;
        private int d;
        private int f;
        private int g;
        private c e = c.ERROR;
        private d h = d.LANGUAGE_VERSION;

        private b() {
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b m() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C13871gx5 a() {
            C13871gx5 c13871gx5K = k();
            if (c13871gx5K.isInitialized()) {
                return c13871gx5K;
            }
            throw a.AbstractC1828a.c(c13871gx5K);
        }

        public C13871gx5 k() {
            C13871gx5 c13871gx5 = new C13871gx5(this);
            int i = this.b;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c13871gx5.d = this.c;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c13871gx5.e = this.d;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c13871gx5.f = this.e;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c13871gx5.g = this.f;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c13871gx5.h = this.g;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            c13871gx5.i = this.h;
            c13871gx5.c = i2;
            return c13871gx5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b e(C13871gx5 c13871gx5) {
            if (c13871gx5 == C13871gx5.C()) {
                return this;
            }
            if (c13871gx5.N()) {
                t(c13871gx5.G());
            }
            if (c13871gx5.O()) {
                u(c13871gx5.H());
            }
            if (c13871gx5.L()) {
                r(c13871gx5.E());
            }
            if (c13871gx5.K()) {
                q(c13871gx5.D());
            }
            if (c13871gx5.M()) {
                s(c13871gx5.F());
            }
            if (c13871gx5.P()) {
                v(c13871gx5.J());
            }
            f(d().h(c13871gx5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C13871gx5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C13871gx5.m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.gx5 r3 = (ir.nasim.C13871gx5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.gx5 r4 = (ir.nasim.C13871gx5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13871gx5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.gx5$b");
        }

        public b q(int i) {
            this.b |= 8;
            this.f = i;
            return this;
        }

        public b r(c cVar) {
            cVar.getClass();
            this.b |= 4;
            this.e = cVar;
            return this;
        }

        public b s(int i) {
            this.b |= 16;
            this.g = i;
            return this;
        }

        public b t(int i) {
            this.b |= 1;
            this.c = i;
            return this;
        }

        public b u(int i) {
            this.b |= 2;
            this.d = i;
            return this;
        }

        public b v(d dVar) {
            dVar.getClass();
            this.b |= 32;
            this.h = dVar;
            return this;
        }

        private void n() {
        }
    }
}
