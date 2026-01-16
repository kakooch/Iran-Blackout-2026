package ir.nasim;

import ir.nasim.C10647bx5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.Sw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7711Sw5 extends kotlin.reflect.jvm.internal.impl.protobuf.h implements V64 {
    private static final C7711Sw5 m;
    public static LW4 n = new a();
    private final kotlin.reflect.jvm.internal.impl.protobuf.d b;
    private int c;
    private int d;
    private int e;
    private c f;
    private C10647bx5 g;
    private int h;
    private List i;
    private List j;
    private byte k;
    private int l;

    /* renamed from: ir.nasim.Sw5$a */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b {
        a() {
        }

        @Override // ir.nasim.LW4
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public C7711Sw5 b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return new C7711Sw5(eVar, fVar);
        }
    }

    /* renamed from: ir.nasim.Sw5$c */
    public enum c implements i.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);

        private static i.b e = new a();
        private final int a;

        /* renamed from: ir.nasim.Sw5$c$a */
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
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        C7711Sw5 c7711Sw5 = new C7711Sw5(true);
        m = c7711Sw5;
        c7711Sw5.V();
    }

    public static C7711Sw5 J() {
        return m;
    }

    private void V() {
        this.d = 0;
        this.e = 0;
        this.f = c.TRUE;
        this.g = C10647bx5.b0();
        this.h = 0;
        this.i = Collections.emptyList();
        this.j = Collections.emptyList();
    }

    public static b W() {
        return b.m();
    }

    public static b X(C7711Sw5 c7711Sw5) {
        return W().e(c7711Sw5);
    }

    public C7711Sw5 F(int i) {
        return (C7711Sw5) this.i.get(i);
    }

    public int G() {
        return this.i.size();
    }

    public c H() {
        return this.f;
    }

    public int K() {
        return this.d;
    }

    public C10647bx5 L() {
        return this.g;
    }

    public int M() {
        return this.h;
    }

    public C7711Sw5 N(int i) {
        return (C7711Sw5) this.j.get(i);
    }

    public int O() {
        return this.j.size();
    }

    public int P() {
        return this.e;
    }

    public boolean Q() {
        return (this.c & 4) == 4;
    }

    public boolean R() {
        return (this.c & 1) == 1;
    }

    public boolean S() {
        return (this.c & 8) == 8;
    }

    public boolean T() {
        return (this.c & 16) == 16;
    }

    public boolean U() {
        return (this.c & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return X(this);
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
            codedOutputStream.c0(4, this.g);
        }
        if ((this.c & 16) == 16) {
            codedOutputStream.Z(5, this.h);
        }
        for (int i = 0; i < this.i.size(); i++) {
            codedOutputStream.c0(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i));
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            codedOutputStream.c0(7, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.j.get(i2));
        }
        codedOutputStream.h0(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public int getSerializedSize() {
        int i = this.l;
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
            iO += CodedOutputStream.r(4, this.g);
        }
        if ((this.c & 16) == 16) {
            iO += CodedOutputStream.o(5, this.h);
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            iO += CodedOutputStream.r(6, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.i.get(i2));
        }
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            iO += CodedOutputStream.r(7, (kotlin.reflect.jvm.internal.impl.protobuf.l) this.j.get(i3));
        }
        int size = iO + this.b.size();
        this.l = size;
        return size;
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
        if (S() && !L().isInitialized()) {
            this.k = (byte) 0;
            return false;
        }
        for (int i = 0; i < G(); i++) {
            if (!F(i).isInitialized()) {
                this.k = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < O(); i2++) {
            if (!N(i2).isInitialized()) {
                this.k = (byte) 0;
                return false;
            }
        }
        this.k = (byte) 1;
        return true;
    }

    private C7711Sw5(h.b bVar) {
        super(bVar);
        this.k = (byte) -1;
        this.l = -1;
        this.b = bVar.d();
    }

    private C7711Sw5(boolean z) {
        this.k = (byte) -1;
        this.l = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.d.a;
    }

    private C7711Sw5(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        this.k = (byte) -1;
        this.l = -1;
        V();
        d.b bVarB = kotlin.reflect.jvm.internal.impl.protobuf.d.B();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(bVarB, 1);
        boolean z = false;
        int i = 0;
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
                        } else if (iJ == 34) {
                            C10647bx5.c builder = (this.c & 8) == 8 ? this.g.toBuilder() : null;
                            C10647bx5 c10647bx5 = (C10647bx5) eVar.t(C10647bx5.v, fVar);
                            this.g = c10647bx5;
                            if (builder != null) {
                                builder.e(c10647bx5);
                                this.g = builder.o();
                            }
                            this.c |= 8;
                        } else if (iJ == 40) {
                            this.c |= 16;
                            this.h = eVar.r();
                        } else if (iJ == 50) {
                            if ((i & 32) != 32) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            this.i.add(eVar.t(n, fVar));
                        } else if (iJ != 58) {
                            if (!m(eVar, codedOutputStreamI, fVar, iJ)) {
                            }
                        } else {
                            if ((i & 64) != 64) {
                                this.j = new ArrayList();
                                i |= 64;
                            }
                            this.j.add(eVar.t(n, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if ((i & 64) == 64) {
                        this.j = Collections.unmodifiableList(this.j);
                    }
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
        if ((i & 32) == 32) {
            this.i = Collections.unmodifiableList(this.i);
        }
        if ((i & 64) == 64) {
            this.j = Collections.unmodifiableList(this.j);
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

    /* renamed from: ir.nasim.Sw5$b */
    public static final class b extends h.b implements V64 {
        private int b;
        private int c;
        private int d;
        private int g;
        private c e = c.TRUE;
        private C10647bx5 f = C10647bx5.b0();
        private List h = Collections.emptyList();
        private List i = Collections.emptyList();

        private b() {
            p();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b m() {
            return new b();
        }

        private void n() {
            if ((this.b & 32) != 32) {
                this.h = new ArrayList(this.h);
                this.b |= 32;
            }
        }

        private void o() {
            if ((this.b & 64) != 64) {
                this.i = new ArrayList(this.i);
                this.b |= 64;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public C7711Sw5 a() {
            C7711Sw5 c7711Sw5K = k();
            if (c7711Sw5K.isInitialized()) {
                return c7711Sw5K;
            }
            throw a.AbstractC1828a.c(c7711Sw5K);
        }

        public C7711Sw5 k() {
            C7711Sw5 c7711Sw5 = new C7711Sw5(this);
            int i = this.b;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c7711Sw5.d = this.c;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c7711Sw5.e = this.d;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c7711Sw5.f = this.e;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c7711Sw5.g = this.f;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c7711Sw5.h = this.g;
            if ((this.b & 32) == 32) {
                this.h = Collections.unmodifiableList(this.h);
                this.b &= -33;
            }
            c7711Sw5.i = this.h;
            if ((this.b & 64) == 64) {
                this.i = Collections.unmodifiableList(this.i);
                this.b &= -65;
            }
            c7711Sw5.j = this.i;
            c7711Sw5.c = i2;
            return c7711Sw5;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return m().e(k());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public b e(C7711Sw5 c7711Sw5) {
            if (c7711Sw5 == C7711Sw5.J()) {
                return this;
            }
            if (c7711Sw5.R()) {
                u(c7711Sw5.K());
            }
            if (c7711Sw5.U()) {
                w(c7711Sw5.P());
            }
            if (c7711Sw5.Q()) {
                t(c7711Sw5.H());
            }
            if (c7711Sw5.S()) {
                s(c7711Sw5.L());
            }
            if (c7711Sw5.T()) {
                v(c7711Sw5.M());
            }
            if (!c7711Sw5.i.isEmpty()) {
                if (this.h.isEmpty()) {
                    this.h = c7711Sw5.i;
                    this.b &= -33;
                } else {
                    n();
                    this.h.addAll(c7711Sw5.i);
                }
            }
            if (!c7711Sw5.j.isEmpty()) {
                if (this.i.isEmpty()) {
                    this.i = c7711Sw5.j;
                    this.b &= -65;
                } else {
                    o();
                    this.i.addAll(c7711Sw5.j);
                }
            }
            f(d().h(c7711Sw5.b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.l.a
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.C7711Sw5.b d0(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                ir.nasim.LW4 r1 = ir.nasim.C7711Sw5.n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                ir.nasim.Sw5 r3 = (ir.nasim.C7711Sw5) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                ir.nasim.Sw5 r4 = (ir.nasim.C7711Sw5) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7711Sw5.b.d0(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):ir.nasim.Sw5$b");
        }

        public b s(C10647bx5 c10647bx5) {
            if ((this.b & 8) != 8 || this.f == C10647bx5.b0()) {
                this.f = c10647bx5;
            } else {
                this.f = C10647bx5.D0(this.f).e(c10647bx5).o();
            }
            this.b |= 8;
            return this;
        }

        public b t(c cVar) {
            cVar.getClass();
            this.b |= 4;
            this.e = cVar;
            return this;
        }

        public b u(int i) {
            this.b |= 1;
            this.c = i;
            return this;
        }

        public b v(int i) {
            this.b |= 16;
            this.g = i;
            return this;
        }

        public b w(int i) {
            this.b |= 2;
            this.d = i;
            return this;
        }

        private void p() {
        }
    }
}
